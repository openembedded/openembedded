#!/bin/sh
#
# configure kernel modules for TI DSP based gstreamer plugin
#

# insert cmemk, tell it to occupy physical 34MB-64MB.
#
modprobe cmemk phys_start=0xC2200000 phys_end=0xC3200000 \
    pools=1x5250000,3x1048576,3x829440,1x256000,4x131072

modprobe dsplinkk

