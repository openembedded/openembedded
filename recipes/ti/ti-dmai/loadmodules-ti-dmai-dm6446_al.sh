#
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

modprobe cmemk phys_start=0x87800000 phys_end=0x88E00000 pools=20x4096,8x202752,10x131072,2x1048576,1x2097152,10x829440,1x6750000
modprobe dsplinkk ddr_start=0x8F800000  ddr_size=0x600000

rm -rf /dev/dsplink
mknod /dev/dsplink c `awk "\\$2==\"dsplink\" {print \\$1}" /proc/devices` 0
