// fis.cc
// see http://svn.chezphil.org/utils
// (C) 2007 Philip Endecott

// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2 of the License, or
// any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.


#include <string>
#include <iostream>
#include <map>

#include <boost/lexical_cast.hpp>
#include <boost/format.hpp>

#include "Exception.hh"
#include "FileDescriptor.hh"
#include "utils.hh"
#include "endian.hh"

#include <stdint.h>

using namespace std;
using namespace boost;
using namespace pbe;


static void check_dev(string device)
{
  if (device=="") {
    throw "You must specify a device using -d";
  }
}


// This is taken from drivers/mtd/redboot.c in the Linux source
struct fis_image_desc {
  char      name[16];      // Null terminated name
  uint32_t  flash_base;    // Address within FLASH of image
  uint32_t  mem_base;      // Address in memory where it executes
  uint32_t  size;          // Length of image
  uint32_t  entry_point;   // Execution entry point
  uint32_t  data_length;   // Length of actual data
  uint32_t  skips[53];
  uint32_t  desc_cksum;    // Checksum over image descriptor
  uint32_t  file_cksum;    // Checksum over image data
};

ostream& operator<<(ostream& strm, const fis_image_desc& d)
{
  strm << format("%16s: addr = 0x%08x, size = 0x%08x\n")
          % (d.name) % (d.flash_base) % (d.size);
  for (unsigned int i=0; i<(sizeof(d.skips)/4); ++i) {
    if (d.skips[i]==0x736b6970 || d.skips[i]==0x70696b73) { // "skip"
      uint32_t offset = d.skips[i+1];
      uint32_t length = d.skips[i+2];
      strm << format("                    skip: %08x + %08x\n")
              % (offset) % (length);
      i+=2;
    }
  }
  return strm;
}


void check_checksum(const fis_image_desc& d)
{
  // This isn't checked by the kernel mtd driver, which has this 
  // comment: "RedBoot doesn't actually write the desc_cksum field yet 
  // AFAICT".  I don't know what checksum is supposed to be used here.
}

void compute_checksum(fis_image_desc& d)
{
  // ditto
}


typedef map<uint32_t,fis_image_desc> dir_t;


static void swap_entry_endianness(fis_image_desc& d)
{
  d.flash_base  = swap_end_32(d.flash_base);
  d.mem_base    = swap_end_32(d.mem_base);
  d.size        = swap_end_32(d.size);
  d.entry_point = swap_end_32(d.entry_point);
  d.data_length = swap_end_32(d.data_length);
  for (unsigned int i=0; i<(sizeof(d.skips)/4); ++i) {
    d.skips[i] = swap_end_32(d.skips[i]);
  }
}


static void load_dir(FileDescriptor& fd, int offset, int size, bool swap_endianness,
                     dir_t& dir)
{
  fd.seek(offset);
  int num_entries = size/sizeof(fis_image_desc);
  for (int i=0; i<num_entries; ++i) {
    fis_image_desc d = fd.binread<fis_image_desc>();
    if (d.name[0]!=static_cast<char>(0xff)) {
      check_checksum(d);
      if (swap_endianness) {
        swap_entry_endianness(d);
      }
      dir[d.flash_base] = d;
    }
  }
}


static void write_blank_entries(FileDescriptor& fd, int n)
{
  char dummy[sizeof(fis_image_desc)];
  for (unsigned int i=0; i<sizeof(fis_image_desc); ++i) {
    dummy[i] = 0xff;
  }
  for (int i=0; i<n; ++i) {
    fd.writeall(dummy,sizeof(fis_image_desc));
  }  
}


static void save_dir(FileDescriptor& fd, int offset, int size, bool swap_endianness,
                     const dir_t& dir)
{
  fd.seek(offset);
  unsigned int num_entries = size/sizeof(fis_image_desc);
  if (num_entries<dir.size()) {
    throw "Too many entries for directory";
  }
  for (dir_t::const_iterator i=dir.begin();
       i!=dir.end(); ++i) {
    fis_image_desc d = i->second;
    compute_checksum(d);
    if (swap_endianness) {
      swap_entry_endianness(d);
    }
    fd.binwrite<fis_image_desc>(d);
  }
  write_blank_entries(fd,num_entries-dir.size());
}


static void fis_list(string device, int offset, int size, bool swap_endianness)
{
  FileDescriptor fd(device,FileDescriptor::read_only);
  dir_t dir;
  load_dir(fd,offset,size,swap_endianness,dir);
  for (dir_t::const_iterator i = dir.begin();
       i != dir.end(); ++i) {
    cout << i->second;
  }
}


static void fis_init(string device, int offset, int size)
{
  FileDescriptor fd(device,FileDescriptor::create);
  fd.seek(offset);
  int num_entries = size/sizeof(fis_image_desc);
  write_blank_entries(fd,num_entries);
}


static void check_overlap(const dir_t& dir, uint32_t addr, uint32_t size)
{
  uint32_t end_addr = addr+size;
  for (dir_t::const_iterator i = dir.begin();
       i != dir.end(); ++i) {
    if (addr<(i->second.flash_base+i->second.size)
        && end_addr>i->second.flash_base) {
      throw "New partition overlaps existing partitions";
    }
  }
}


static void fis_create(string device, int offset, int size, bool swap_endianness,
                       int argc, char* argv[])
{
  fis_image_desc d;
  d.mem_base = 0;
  d.entry_point = 0;
  d.data_length = 0;
  for (unsigned int i=0; i<(sizeof(d.skips)/4); ++i) {
    d.skips[i] = 0;
  }
  d.desc_cksum = 0;
  d.file_cksum = 0;
  
  for (int i=0; i<argc; ++i) {
    string arg=argv[i];
    if (arg=="-l") {
      if (i==argc-1) {
        throw "argumnet missing for -l";
      }
      ++i;
      d.size = maybe_hex_string_to_int(argv[i]);
    } else if (arg=="-f") {
      if (i==argc-1) {
        throw "argumnet missing for -f";
      }
      ++i;
      d.flash_base = maybe_hex_string_to_int(argv[i]);
    } else if (arg=="-n") {
      if (i==argc-1) {
        throw "argumnet missing for -n";
      }
      ++i;
      string name = argv[i];
      if (name.length()>=16) {
        throw "name too long, max 16 chars including terminating null";
      }
      for (int j=0; j<16; j++) {
        char c = name.c_str()[j];
        d.name[j] = c;
        if (!c) {
          for (; j<16; ++j) {
            d.name[j]=0;
          }
          break;
        }
      }
    } else {
      cerr << "Unrecognised option '" << arg << "'\n";
      exit(1);
    }
  }

  FileDescriptor fd(device,FileDescriptor::read_write);
  dir_t dir;
  load_dir(fd,offset,size,swap_endianness,dir);
  check_overlap(dir,d.flash_base,d.size);
  dir[d.flash_base] = d;
  save_dir(fd,offset,size,swap_endianness,dir);
}


static void fis_delete(string device, int offset, int size, bool swap_endianness,
                       string name)
{
  FileDescriptor fd(device,FileDescriptor::read_write);
  dir_t dir;
  load_dir(fd,offset,size,swap_endianness,dir);

  for (dir_t::iterator i = dir.begin();
       i != dir.end(); ++i) {
    string this_name(i->second.name);
    if (this_name == name) {
      dir.erase(i);
      save_dir(fd,offset,size,swap_endianness,dir);
      return;
    }
  }

  throw "No partition found with specified name";
}


static void usage()
{
  cerr << "Usage:\n"
       << "  fis [options] list\n"
       << "  fis [options] init\n"
       << "  fis [options] create -f address -l size -n name\n"
       << "  fis [options] delete name\n"
       << "Options:\n"
       << "  -d device    specify /dev/mtd* device containing directory\n"
       << "  -o offset    specify offset into device of start of directory\n"
       << "               (in decimal; prefix with 0x for hex)\n"
       << "  -s size      specify size of directory in bytes\n"
       << "  -e           swap endianness\n";
}


int main(int argc, char* argv[])
{
  try { try {

    if (argc==1) {
      usage();
      exit(1);
    }

    string device="";
    int offset=0;
    int size=0;
    bool swap_endianness=false;

    for (int i=1; i<argc; ++i) {
      string arg = argv[i];
      if (arg=="-d") {
        if (device!="") {
          throw "-d option used more than once";
        }
        if (i==argc-1) {
          throw "-d option is missing its parameter";
        }
        ++i;
        device = argv[i];
      } else if (arg=="-o") {
        if (offset!=0) {
          throw "-o option used more than once";
        }
        if (i==argc-1) {
          throw "-o option is missing its parameter";
        }
        ++i;
        offset = maybe_hex_string_to_int(argv[i]);
      } else if (arg=="-s") {
        if (size!=0) {
          throw "-s option used more than once";
        }
        if (i==argc-1) {
          throw "-s option is missing its parameter";
        }
        ++i;
        size = maybe_hex_string_to_int(argv[i]);
      } else if (arg=="-e") {
        swap_endianness = true;
      } else if (arg=="list") {
        if (i!=argc-1) {
          throw "Extra arguments after 'list'";
        }
        check_dev(device);
        fis_list(device,offset,size,swap_endianness);
      } else if (arg=="init") {
        if (i!=argc-1) {
          throw "Extra arguments after 'init'";
        }
        check_dev(device);
        fis_init(device,offset,size);
      } else if (arg=="create") {
        check_dev(device);
        fis_create(device,offset,size,swap_endianness,
                   argc-i-1,&argv[i+1]);
        break;
      } else if (arg=="delete") {
        if (i!=argc-2) {
          throw "Exactly one argumnet required after 'delete'";
        }
        ++i;
        string name = argv[i];
        check_dev(device);
        fis_delete(device,offset,size,swap_endianness,name);
      } else {
        cerr << "unrecognised argument '" << arg << "'\n";
        usage();
        exit(1);
      }
    }
  } RETHROW_MISC_EXCEPTIONS }
  catch (Exception& E) {
    cerr << "Error: ";
    E.report(cerr);
    exit(1);
  }
}

