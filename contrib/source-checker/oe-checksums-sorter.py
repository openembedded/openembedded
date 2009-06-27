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


import ConfigParser
import getopt
import os
import sys
import tempfile

def usage(rc):
    print """usage: %s [--inplace|-i] conf/checksums.ini

    --inplace, -i: update file in place (default is to write to stdout)

    If no input file is given, will read from standard input.
    """ % sys.argv[0]
    sys.exit(rc)

try:
    optlist, args = getopt.getopt(sys.argv[1:], "ih", ["inplace", "help"])
except getopt.GetoptError, e:
    print >> sys.stderr, "%s: %s" % (sys.argv[0], e)
    usage(1)

inplace = False
infp = sys.stdin
filename = None
for opt, val in optlist:
    if opt == '-i' or opt == '--inplace':
        inplace = True
    elif opt == 'h' or opt == '--help':
        usage(0)
    else:
        print >> sys.stderr, "%s: %s: invalid argument" % (sys.argv[0], opt)
        usage(1)

if len(args) == 0:
    if inplace:
        print >> sys.stderr, "%s: --inplace requires a filename" % sys.argv[0]
        usage(1)
elif len(args) == 1:
    filename = args[0]
    try:
        infp = open(filename, "r")
    except Exception, e:
        print >> sys.stderr, "%s: %s" % (sys.argv[0], e)
        sys.exit(1)
else:
    print >> sys.stderr, "%s: extra arguments" % sys.argv[0]
    usage(1)

out = sys.stdout
tmpfn = None
if inplace:
    outfd, tmpfn = tempfile.mkstemp(prefix='cksums',
                                    dir=os.path.dirname(filename) or '.')
    os.chmod(tmpfn, os.stat(filename).st_mode)
    out = os.fdopen(outfd, 'w')

checksums_parser = ConfigParser.ConfigParser()
checksums_parser.readfp(infp)

new_list = []
seen = {}

for source in checksums_parser.sections():
    archive = source.split("/")[-1]
    md5 = checksums_parser.get(source, "md5")
    sha = checksums_parser.get(source, "sha256")

    tup = (archive, source, md5, sha)
    if not seen.has_key(tup):
        new_list.append(tup)
        seen[tup] = 1

new_list.sort()

for entry in new_list:
    print >> out, "[%s]\nmd5=%s\nsha256=%s\n" % (entry[1], entry[2], entry[3])

if inplace:
    out.close()
    os.rename(tmpfn, filename)
