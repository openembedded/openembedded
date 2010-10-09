#!/bin/sh
#
# configure kernel modules for TI DSP based gstreamer plugin
#
rmmod cmemk 2>/dev/null
rmmod dsplink 2>/dev/null

modprobe cmemk phys_start=0xC2200000 phys_end=0xC3200000 \
    pools=1x5250000,3x1048576,3x829440,1x256000,4x131072 \
    allowOverlap=1

modprobe dsplinkk

rm -f /dev/dsplink
mknod /dev/dsplink c `awk "\\$2==\"dsplink\" {print \\$1}" /proc/devices` 0

