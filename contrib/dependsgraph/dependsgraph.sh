#!/bin/bash
#
# This script attempts to repair the use of creating
# dependency graphs of packages.
#
# This got unusuable, (and broken beyond repair?) with
# enhancements to bitbake in its dependency tracking.
#
# This script is a hack. It works for me.
#
# Apply the patch from this bug report to bitbake
# (if not yet upstream), tested against r1152 of
# svn://svn.berlios.de/bitbake/branches/bitbake-1.8
#
# http://bugs.openembedded.net/show_bug.cgi?id=5002
#

IGNORE_DEPENDS=" \
-native -dbg -dev -doc -info -locale -cross -initial -r[0-9]* \
-intermediate -linux-gcc -linux-binutils -linux-libc-for-gcc linux-libc-headers \
"

IGNORE_DASHED="dashed]"

if [ ! -f depends.dot ]; then
  echo "Cannot find ./depends.dot"
#  exit
fi

which dot
if [ ! $? -eq 0 ]; then
  echo "Install graphviz on your host."
  exit
fi

echo -n >/tmp/delete.sed
for IGNORE in $IGNORE_DEPENDS $IGNORE_DASHED ;
do
  echo /$IGNORE/d >>/tmp/delete.sed
done

#cat /tmp/delete.sed

# first, delete a lot of (noisy) nodes and edges.
sed -f /tmp/delete.sed depends.dot >reduced.dot

# create a PNG
dot -v -Tpng -o depends.png reduced.dot

# show it
gthumb depends.png
