#!/usr/bin/env python
# ex:ts=4:sw=4:sts=4:et

# Copyright (C) 2007 OpenedHand
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
# OpenEmbedded source checksums checker
#
# This script parse conf/checksums.ini and check does files contained in
# source archive are the same as the one used to generate checksums.
#
# Run it:
#
# oe-source-checker.py path-to-conf/checksums.ini path-to-sources
#
#
# How to deal with output:
#
# 1. download each failed entry
# 2. check md5 and sha256 of file
# 3. correct checksums.ini if needed
# 4. share changes
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
files_wrong   = []

for source in checksums_parser.sections():
    archive = source.split("/")[-1]
    localpath = os.path.join(sys.argv[2], archive)
    md5 = checksums_parser.get(source, "md5")
    sha = checksums_parser.get(source, "sha256")

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

        shapipe = os.popen("oe_sha256sum " + localpath)
        shadata = (shapipe.readline().split() or [ "" ])[0]
        shapipe.close()

        if shadata != "" and sha != shadata:
            file_ok = False

        if file_ok:
            files_good += 1
        else:
            files_wrong += [ [md5, md5data, sha, shadata, archive, source] ]
    except:
        pass

print "\nChecked %d files. %d was OK and %d had wrong checksums." % (files_checked, files_good, len(files_wrong))

if len(files_wrong) > 0:

    print "\n"

    for wrong_file in files_wrong:
        print "%s [%s] is wrong" % ( wrong_file[4], wrong_file[5])
        print "md5: %s instead of %s" % (wrong_file[1], wrong_file[0])
        print "sha: %s instead of %s" % (wrong_file[3], wrong_file[2])
