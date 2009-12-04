#!/bin/sh
rmmod cmemk 2>/dev/null
rmmod irqk 2>/dev/null
rmmod edmak 2>/dev/null
rmmod dm365mmap 2>/dev/null

# Pools configuration
insmod cmemk.ko phys_start=0x85000000 phys_end=0x88000000 pools=6x4096,2x8192,1x11908,2x13184,1x2697152,6x4096,1x30720,3x81920,1x3185664,64x56,1x320,1x640,1x81920,1x6650880,2x608,1x296,1x28,2x24,23x1548288,1x154288 allowOverlap=1 phys_start_1=0x00001000 phys_end_1=0x00008000 pools_1=1x28672

insmod irqk.ko 
insmod edmak.ko
insmod dm365mmap.ko
rm -f /dev/dm365mmap
mknod /dev/dm365mmap c `awk "\\$2==\"dm365mmap\" {print \\$1}" /proc/devices` 0
