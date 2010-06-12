#!/bin/sh
rmmod cmemk 2>/dev/null
rmmod irqk 2>/dev/null
rmmod edmak 2>/dev/null
rmmod dm365mmap 2>/dev/null

# Pools configuration
insmod cmemk.ko phys_start=0x84d00000 phys_end=0x88000000 pools=1x16539648,1x4841472,4x1843200,14x1646592,1x282624,1x176128,1x147456,1x69632,1x61440,1x32768,2x20480,1x12288,1x8192,72x4096

# Decode + Display
#insmod cmemk.ko phys_start=0x83c00000 phys_end=0x88000000 pools=1x16539648,1x4841472,14x1646592,1x282624,1x176128,1x147456,1x69632,1x61440,1x32768,2x20480,1x12288,1x8192,64x4096

# Capture + Encode
#insmod cmemk.ko phys_start=0x83c00000 phys_end=0x88000000 pools=1x3112960,1x2764800,3x1536000,1x65536,1x61440,1x49152,1x20480,1x16384,2x8192,87x4096

# Resizer
#insmod cmemk.ko phys_start=0x83c00000 phys_end=0x88000000 pools=3x1843200

# Non-accel display
#insmod cmemk.ko phys_start=0x83c00000 phys_end=0x88000000 pools=1x1843200

insmod irqk.ko 
insmod edmak.ko
insmod dm365mmap.ko

rm -f /dev/dm365mmap
mknod /dev/dm365mmap c `awk "\\$2==\"dm365mmap\" {print \\$1}" /proc/devices` 0
