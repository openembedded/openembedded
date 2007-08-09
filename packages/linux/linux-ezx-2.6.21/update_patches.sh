#!/bin/sh
set -e

# Helper script to update patches and speedup filling the SRC_URI section of our .bb
# Run it while in packages/linux/linux-ezx-2.6.x/

[ -d patches ] && mtn drop -R patches
rm -rf patches

svn --quiet co http://svn.openezx.org/trunk/src/kernel-2.6/patches/ patches
find patches -type f -print0 
mtn add patches patches/*

cat patches/series | grep ^[0-9A-Za-z] | sed -e 's/.*/\tfile:\/\/patches\/\0;patch=1 \\/'
ls -1 patches/defconfig-* | sed -e 's/.*/\tfile:\/\/\0 \\/'

