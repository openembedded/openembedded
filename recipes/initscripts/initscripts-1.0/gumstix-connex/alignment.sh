#!/bin/sh

if [ -e /proc/cpu/alignment ]; then
   echo "2" > /proc/cpu/alignment
fi

