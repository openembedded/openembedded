#!/bin/bash

if ! [ -d libqpe ] ; then
    echo "Please execute at the recipes subdir of the OE source tree"
    exit 1
fi

if [ x$2 == x ] ; then
    echo "usage: $0 dl_dir version"
    exit 1
fi

if ! [ -d $1 ] ; then
    echo "Source dir $1 does not exist"
    exit 1
fi

FILES="libqpe libqtaux libopie* libmailwrapper opie*"

REWR=`readlink -m $0`
REWR="python `dirname $REWR`/opie_checksum_rewrite.py"

for i in $FILES ; do
	for j in $i/*_$2.bb ; do
		if [ -f $j ] ; then
			echo $j
			$REWR $j $1
			if [ $? -ne 0 ] ; then
				echo "Exiting due to error"
				exit 1
			fi
		fi
	done
done

