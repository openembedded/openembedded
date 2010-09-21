#!/bin/sh
# 
# Default DM365 Memory Map 128 MB
#
# Start Addr    Size    Description
# ----------------------------------------------------------------
# 0x00001000    32K     ARM926 TCM memory used by platinum codec
# 0x80000000    48 MB   Linux
# 0x83000000    12 MB   Video driver memory (Linux)
# 0x83C00000    68 MB   CMEM
# 0x88000000    BOTTOM  ADDRESS
#

rmmod cmemk 2>/dev/null

# Pools configuration
modprobe cmemk phys_start=0x83C00000 phys_end=0x88000000 pools=1x16539648,1x4841472,4x1843200,14x1646592,1x282624,1x176128,1x147456,1x69632,1x61440,1x32768,2x20480,1x16384,1x12288,4x8192,69x4096 allowOverlap=1 phys_start_1=0x00001000 phys_end_1=0x00008000 pools_1=1x28672 

# Decode + Display
#modprobe cmemk phys_start=0x83c00000 phys_end=0x88000000 pools=1x16539648,1x4841472,14x1646592,1x282624,1x176128,1x147456,1x69632,1x61440,1x32768,2x20480,1x12288,1x8192,64x4096

# Capture + Encode
#modprobe cmemk phys_start=0x83c00000 phys_end=0x88000000 pools=1x3112960,1x2764800,3x1536000,1x65536,1x61440,1x49152,1x20480,1x16384,2x8192,87x4096

# Resizer
#modprobe cmemk phys_start=0x83c00000 phys_end=0x88000000 pools=3x1843200

# Non-accel display
#modprobe cmemk phys_start=0x83c00000 phys_end=0x88000000 pools=1x1843200

modprobe irqk
modprobe edmak
modprobe dm365mmap

rm -f /dev/dm365mmap
mknod /dev/dm365mmap c `awk "\\$2==\"dm365mmap\" {print \\$1}" /proc/devices` 0

