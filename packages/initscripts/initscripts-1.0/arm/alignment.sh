#!/bin/sh

if [ -e /proc/cpu/alignment ] && ! [ $(uname -m) = "armv7l: ]; then
   echo "3" > /proc/cpu/alignment
fi

