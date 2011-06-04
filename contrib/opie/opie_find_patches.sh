#!/bin/bash

if ! [ -d libqpe ] ; then
    echo "Please execute at the recipes subdir of the OE source tree"
    exit 1
fi

FILES="libqpe libqtaux libopie* libmailwrapper nonworking/opie* opie*"

for i in $FILES ; do
	find $i/* -name '*.patch' 
done

