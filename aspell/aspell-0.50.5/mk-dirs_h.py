#!/usr/bin/env python

import sys

prefix=sys.argv[1]
key=sys.argv[2]
value=sys.argv[3]

while prefix[-1] == '/':
    prefix = prefix[:-2]

plen = len(prefix)

if value[:plen] == prefix:
    value = value[plen:]
    while value[0] == '/':
        value = value[1:]
    print "#define " + key + " \"<prefix:" + value + ">\"\n"
else:
    print "#define " + key + " \"" + value + "\"\n"
