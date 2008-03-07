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

# This is what has been built with:
# ANGSTROM_MODE=uclibc MACHINE=h4000 IMAGE_FSTYPES="cpio.gz" bitbake liveramdisk-image
LIVERAMDISK_FILE=~/pfalcon/Angstrom-liveramdisk-uclibc-ipk-2007.12-r10-h4000.rootfs.cpio.gz
# Directory where HaRET source has been checked out
HARET_PATH=~/pfalcon/haret

# HaRET executable
HARET_EXE=$HARET_PATH/haret-0.5.0.exe
LIVERAMDISK_SCRIPT=$HARET_PATH/tools/safeboot-initramfs.txt

for m in $MACHINES; do
    for f in `find $m -name "A*x11-image*.$EXT" -o -name "A*opie-image*.$EXT"`; do
	base=$(basename $f .$EXT)
	dir=$(dirname $f)
	image_name=`expr "$base" : '\(.\+\)-glibc.*'`
	image_ver=`expr "$base" : '.\+-glibc-ipk-\(.*\)\.rootfs'`
	liveramdisk_name="$image_name-liveramdisk-$image_ver.exe"
	# Use the latest kernel version
	kernel_name=`ls -1 -t $dir/zImage* | head -n1`

        if [ ! -f "$dir/$liveramdisk_name" ]; then
    	    echo "$f (+ $kernel_name) - need gen"
	    
	    # Generate complete LiveRamdisk initramfs by putting jffs2 rootfs into liveramdisk-image cpio
    	    gzip -d -c $LIVERAMDISK_FILE | $HARET_PATH/tools/cpio-append.py $f initrd.jffs2 | gzip -c > $dir/$base.liveramdisk.cpio.gz
	    # Now create executable bundle from all 4 parts
    	    $HARET_PATH/tools/make-bootbundle.py \
		$HARET_EXE \
        	$kernel_name \
        	$dir/$base.liveramdisk.cpio.gz \
        	$LIVERAMDISK_SCRIPT \
		-o "$dir/$liveramdisk_name"
	    # Remove temporary file
	    rm $dir/$base.liveramdisk.cpio.gz
	else
    	    echo $dir/$liveramdisk_name - already there
        fi
    done
done
