#!/bin/sh

# This loadmodules script is provided to support 1920x1080 resolution file based encode/decode DMAI unit test applications

# Sample bootargs is given below
# mem=60M console=ttyS0,115200n8 root=/dev/nfs rw nfsroot=<nfsroot> ip=dhcp video=davincifb:vid0=OFF:vid1=OFF:osd0=720x576x16,2025K dm365_imp.oper_mode=0

depmod -a
rmmod cmemk 2>/dev/null
rmmod irqk 2>/dev/null
rmmod edmak 2>/dev/null
rmmod dm365mmap 2>/dev/null

# Pools configuration
modprobe cmemk phys_start=0x83C00000 phys_end=0x88000000 pools=1x384,2x5984,2x3133440,1x16384,1x48952,1x20480,1x60288,1x74,1x28,1x2048,1x6785280,1x146,1x896,1x65536,1x98,1x296,29x56,2x24,1x624,4x62,1x1456,1x18321120,1x65792,5x3523584,1x4194304,1x8355840

#VC1 decode pool configuration
# insmod cmemk.ko phys_start=0x83C00000 phys_end=0x88000000 pools=1x384,1x112665,3x7680,1x319264,2x1024,5x7208960,1x80,1x116,1x29184,1x2688,1x30720,1x551680,2x128,1x74,1x28,1x10240,1x47232,1x448,2x1152,1x8192,2x272896,18x56,2x24,1x86,4x62,2x7808,1x2097152

modprobe irqk
modprobe edmak
modprobe dm365mmap

rm -f /dev/dm365mmap
mknod /dev/dm365mmap c `awk "\\$2==\"dm365mmap\" {print \\$1}" /proc/devices` 0
