#!/bin/sh

# Default Memory Map
#
# Start Addr    Size    Description
# -------------------------------------------
# 0x80000000     76 MB  Linux
# 0x84C00000    110 MB  CMEM
# 0x8ba00000     70 MB  CODEC SERVER

# Sample bootargs is given below
# mem=76M console=ttyS0,115200n8 root=/dev/nfs rw nfsroot=<nfsroot> ip=dhcp vpif_display.ch2_numbuffers=0 vpif_display.ch3_numbuffers=0 

rmmod cmemk 2>/dev/null
rmmod dsplinkk 2>/dev/null 

modprobe cmemk phys_start=0x84C00000 phys_end=0x8ba00000 pools=2x921600,1x460800,1x1048576,1x345600,2x86400,11x564528,5x677376,14x5396480,3x4147200,4x1451520,4x1843200

modprobe dsplinkk

# alter dma queue mapping for better visual performance
if [ -f mapdmaq-hd ]
then
    ./mapdmaq-hd
fi

# make /dev/dsplink
rm -f /dev/dsplink
mknod /dev/dsplink c `awk "\\$2==\"dsplink\" {print \\$1}" /proc/devices` 0

