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


import sys, ConfigParser

checksums_parser = ConfigParser.ConfigParser()
checksums_parser.read(sys.argv[1])

for source in checksums_parser.sections():
    archive = source.split("/")[-1]
    localpath = sys.argv[2] + "/" + archive
    md5 = checksums_parser.get(source, "md5")
    sha = checksums_parser.get(source, "sha256")

    try:
        os.stat(localpath)
        try:
            md5pipe = os.popen('md5sum ' + localpath)
            md5data = (md5pipe.readline().split() or [ "" ])[0]
            md5pipe.close()
        except OSError:
            raise Exception("Executing md5sum failed")

        try:
            shapipe = os.popen("oe_sha256sum " + localpath)
            shadata = (shapipe.readline().split() or [ "" ])[0]
            shapipe.close()
        except OSError:
            raise Exception("Executing shasum failed")

        if md5 != md5data:
            print "%s has wrong md5: %s instead of %s url: %s" % (archive, md5data, md5, source) 

        if sha != shadata:
            print "%s has wrong sha: %s instead of %s url: %s" % (archive, shadata, sha, source) 
    except:
        pass
