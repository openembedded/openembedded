#!/bin/sh

# Default Memory Map
#
# Start Addr    Size    Description
# -------------------------------------------
# 0x80000000    96 MB   Linux
# 0x86000000    32 MB   CMEM

# Sample bootargs is given below
# mem=96M console=ttyS0,115200n8 root=/dev/nfs rw nfsroot=<nfsroot> ip=dhcp video=davincifb:vid0=OFF:vid1=OFF:osd0=720x576x16,2025K

rmmod cmemk 2>/dev/null
rmmod irqk 2>/dev/null
rmmod edmak 2>/dev/null
rmmod dm350mmap 2>/dev/null

modprobe cmemk phys_start=0x86000000 phys_end=0x88000000 pools=10x829440,1x1529856,1x276,1x4320,1x560,2x344,1x144,1x81920,2x512,1x14000,1x12960,1x11360,1x4,2x296,1x8192,59x56,4x24,1x1505280,9x1658880,1x2258880

./mapdmaq

modprobe irqk 
modprobe edmak
modprobe dm350mmap

rm -f /dev/dm350mmap
mknod /dev/dm350mmap c `awk "\\$2==\"dm350mmap\" {print \\$1}" /proc/devices` 0
