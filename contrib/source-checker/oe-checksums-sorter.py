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
# OpenEmbedded source checksums sorter
#
# This script parse conf/checksums.ini and sorts it alphabetically by archive
# name source archive. Duplicate entries are removed.
#
# Run it:
#
# oe-checksums-sorter.py path-to-conf/checksums.ini
#
#


import sys

if len(sys.argv) < 2:
    print """
    OpenEmbedded source checksums script require argument:

    1. location of conf/checksums.ini
    """
    sys.exit(0)

import ConfigParser, os

checksums_parser = ConfigParser.ConfigParser()
checksums_parser.read(sys.argv[1])

item = 1;
files_total   = len(checksums_parser.sections())

new_list = []

for source in checksums_parser.sections():
    archive = source.split("/")[-1]
    md5 = checksums_parser.get(source, "md5")
    sha = checksums_parser.get(source, "sha256")

    if new_list.count([archive, source, md5, sha]) < 1:
        new_list += [[archive, source, md5, sha]]

new_list.sort()

for entry in new_list:
    print "[%s]\nmd5=%s\nsha256=%s\n" % (entry[1], entry[2], entry[3])
