#!/bin/sh

if [ -z "`which chkhinge`" ]; then
   # probably not a zaurus
   exit 0
fi

chkhinge -e
if [ $? = 10 ]; then
   xrandr -o right
fi

