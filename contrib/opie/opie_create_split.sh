#!/bin/bash

if [ x$2 == x ] ; then
    echo "usage: $0 sourcedir pathsfile [outdir]"
    exit 1
fi

if ! [ -d $1 ] ; then
    echo "Source dir $1 does not exist"
    exit 1
else
    if ! [ -f $1/library/version.h ] ; then
        echo "Source dir $1 doesn't contain an opie source tree"
	exit 1
    fi
fi

# FIXME this could be produced on the fly using some python code
# (perhaps hack opie_checksum_rewrite.py)
if ! [ -f $2 ] ; then
    echo "Paths file $2 does not exist"
    exit 1
fi

if [ x$3 != x ] ; then
    OUT_DIR=$3
    if ! [ -d $3 ] ; then
        echo "Output dir $3 does not exist"
        exit 1
    fi
else
    OUT_DIR=`pwd`
fi

OLD_PWD=`pwd`

PATHS_FILE=`readlink -m $2`

cd $1
OPIE_VERSION=`grep QPE_VERSION library/version.h | awk '{ print $3 }' | sed 's/"//g'`

for i in `cat $PATHS_FILE`; do
	echo $i
	tar -c -C `dirname $i` -j -f $OUT_DIR/opie-$OPIE_VERSION-split_`echo $i | sed 's/\//_/g'`.tar.bz2 `basename $i`
	if [ $? -ne 0 ] ; then
		echo "Exiting due to error"
		exit 1
	fi
done

cd $OUT_DIR
md5sum *.tar.bz2 > md5sums

cd $OLD_PWD

