#!/bin/sh

#
# This script generates LiveRamdisk executable image from:
# 1. jffs2 rootfs images
# 2. LiveRamdisk initramfs image
# 3. Kernel
# 4. HaRET script
# Requires both HaRET sources and executable
#

MACHINES="h2200 h3900 h4000 h5000 hx4700 htcapache htcblueangel htcuniversal"

EXT="jffs2"

LIVERAMDISK_FILE=~/pfalcon/Angstrom-liveramdisk-uclibc-ipk-2007.11RC1.3-h4000.rootfs.cpio.gz
HARET_PATH=~/pfalcon/haret

HARET_EXE=$HARET_PATH/haret-0.5.0.exe
LIVERAMDISK_SCRIPT=$HARET_PATH/tools/safeboot-initramfs.txt

for m in $MACHINES; do
    for f in `find $m -name "A*x11-image*.$EXT" -o -name "A*opie-image*.$EXT"`; do
	base=$(basename $f .$EXT)
	dir=$(dirname $f)
	image_name=`expr "$base" : '\(.\+\)-glibc.*'`
	image_ver=`expr "$base" : '.\+-glibc-ipk-\(.*\)\.rootfs'`
	liveramdisk_name="$image_name-liveramdisk-$image_ver.exe"

        if [ ! -f "$dir/$liveramdisk_name" ]; then
    	    echo $f - need gen
    	    gzip -d -c $LIVERAMDISK_FILE | $HARET_PATH/tools/cpio-append.py $f initrd.jffs2 | gzip -c > $dir/$base.liveramdisk.cpio.gz
    	    $HARET_PATH/tools/make-bootbundle.py $HARET_EXE \
        	`ls -1 -t $dir/zImage* | head -n1` \
        	$dir/$base.liveramdisk.cpio.gz \
        	$LIVERAMDISK_SCRIPT \
		-o "$dir/$liveramdisk_name"
	    rm $dir/$base.liveramdisk.cpio.gz
	else
    	    echo $dir/$liveramdisk_name - already there
        fi
    done
done
