#!/bin/sh

#
# This script generates ext2 images for loopback install from tar.gz images.
# requires tar2ext2 script
#

MACHINES="h2200 h3900 h4000 h5000 hx4700 htcapache htcblueangel htcuniversal"
SIZE="80" # in MB

EXT="tar.gz"

for m in $MACHINES; do
    for f in `find $m -name "A*x11-image*.$EXT" -o -name "A*opie-image*.$EXT"`; do
	base=$(basename $f .$EXT)
	dir=$(dirname $f)
        if [ ! -f $dir/$base.img.bz2 ]; then
    	    echo $f - need gen
	    tar2ext2 $f $SIZE
	    bzip2 -f -9 $dir/$base.img
	else
    	    echo $f - already there
        fi
    done
done
