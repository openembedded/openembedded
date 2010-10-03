#!/bin/sh
#
# Default Memory Map
#
# Start Addr    Size    Description
# -------------------------------------------
# 0x80000000     99 MB  Linux
# 0x86300000     15 MB  CMEM
# 0x87200000     13 MB  CODEC SERVER

# remove previously loaded cmem module and use our pool configuration.
rmmod cmemk 2>/dev/null

# Allocate 15MB for CMEM
modprobe cmemk phys_start=0x86300000 phys_end=0x87200000 pools=1x3000000,1x1429440,6x1048576,4x829440,1x327680,1x256000,7x131072,20x4096 allowOverlap=1

# insert DSP/BIOS Link driver
modprobe dsplinkk

# make /dev/dsplink
rm -f /dev/dsplink
mknod /dev/dsplink c `awk "\\$2==\"dsplink\" {print \\$1}" /proc/devices` 0

# insert Local Power Manager driver
modprobe lpm_omap3530

# insert SDMA driver
modprobe sdmak

