#!/bin/sh

if [ -e /proc/cpu/alignment ] ; then
   if [ $(uname -m) = "armv7l" ]; then
       echo "0" > /proc/cpu/alignment
   else
       echo "3" > /proc/cpu/alignment
   fi
fi

