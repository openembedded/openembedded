#!/usr/bin/env python
# ex:ts=4:sw=4:sts=4:et

# Copyright (C) 2009 Marcin Juszkiewicz <marcin@juszkiewicz.com.pl>
#
# based on my oe-source-checker.py which is (C) OpenedHand
#
# This program is free software; you can redistribute it and/or modify
# it under the terms of the GNU General Public License version 2 as
# published by the Free Software Foundation.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License along
# with this program; if not, write to the Free Software Foundation, Inc.,
# 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.

#
# OpenEmbedded source mirror build script
#
# This script parse conf/checksums.ini and check does files contained in
# source archive are the same as the one used to generate checksums.
# If they are then their names are output.
#
# Run it:
#
# oe-source-mirror-build.py path-to-conf/checksums.ini path-to-sources
#

import sys

if len(sys.argv) < 3:
    print """
    OpenEmbedded source checker script require two arguments:

    1. location of conf/checksums.ini
    2. path to DL_DIR (without "/" at the end)
    """
    sys.exit(0)

import ConfigParser, os, itertools

checksums_parser = ConfigParser.ConfigParser()
checksums_parser.read(sys.argv[1])

parsespin = itertools.cycle( r'|/-\\' )

item = 1;
files_total   = len(checksums_parser.sections())
files_checked = 0
files_good    = 0
files_mirror  = []

for source in checksums_parser.sections():
    archive = source.split("/")[-1]
    localpath = os.path.join(sys.argv[2], archive)
    md5 = checksums_parser.get(source, "md5")

    if os.isatty(sys.stdout.fileno()):
        sys.stdout.write("\rChecking files: %s (%04d/%04d) [%2d %%]" % ( parsespin.next(), item, files_total, item*100/files_total ) )
        sys.stdout.flush()
        item += 1

    try:
        os.stat(localpath)
    except:
        continue

    files_checked += 1
    file_ok = True

    try:
        md5pipe = os.popen('md5sum ' + localpath)
        md5data = (md5pipe.readline().split() or [ "" ])[0]
        md5pipe.close()

        if md5 != md5data:
            file_ok = False

        if file_ok:
            files_good += 1
            files_mirror += [ archive ]
    except:
        pass

print "\nChecked %d files. %d was OK." % (files_checked, files_good)

if len(files_mirror) > 0:

    print "\n"

    for entry in files_mirror:
        print "%s " % entry
