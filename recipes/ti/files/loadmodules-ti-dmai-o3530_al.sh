# loadmodules.sh
#
# Copyright (C) $year Texas Instruments Incorporated - http://www.ti.com/
#
# This program is free software; you can redistribute it and/or modify 
# it under the terms of the GNU Lesser General Public License as
# published by the Free Software Foundation version 2.1 of the License.
#
# This program is distributed #as is# WITHOUT ANY WARRANTY of any kind,
# whether express or implied; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
# Lesser General Public License for more details.

#
# Default Memory Map
#
# Start Addr    Size    Description
# -------------------------------------------
# 0x80000000    88 MB   Linux
# 0x85800000    08 MB   CMEM
# 0x86800000    24 MB   DDRALGHEAP
# 0x87800000     6 MB   DDR2 (BIOS, Codecs, Applications)
# 0x87E00000     1 MB   DSPLINK (MEM)
# 0x87F00000     4 KB   DSPLINK (RESET)
# 0x87F01000  1020 KB   unused

modprobe cmemk phys_start=0x85800000 phys_end=0x86800000 pools=20x4096,8x131072,4x829440,1x5250000,1x1429440,1x256000


# insert DSP/BIOS Link driver
#
modprobe dsplinkk

# make /dev/dsplink
rm -f /dev/dsplink
mknod /dev/dsplink c `awk "\\$2==\"dsplink\" {print \\$1}" /proc/devices` 0


# insert Local Power Manager driver
#
modprobe lpm_omap3530

