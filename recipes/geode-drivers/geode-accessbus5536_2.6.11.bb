# AccessBus OE build file for the AMD Geode 5535/5536
# Copyright (C) 2005-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "Linux Access Bus driver for the AMD Geode 5535/5536"
HOMEPAGE = "http://www.amd.com/embedded"

PR = "r0"
AMD_DRIVER_VERSION = "01.00.0401"
AMD_DRIVER_LABEL = "AccessBus_Linux_5536_${AMD_DRIVER_VERSION}"

require geode-modules.inc
SRC_URI[md5sum] = "9e738b508a6031946ad15b6591d0e5d4"
SRC_URI[sha256sum] = "d1edbe9c1c17cc3cc712b0b776c3eeab1f928f9e0a32467a4cb5a201c2902ab8"
#CHECKSUMS.INI MISMATCH: I've got this instead:
#SRC_URI[md5sum] = "8664fb4e38fd2b6da7571d92ac8c3d45"
#SRC_URI[sha256sum] = "00c237a57b39ce4f3de4b37f91f6c48aad72fd3a36ae07012f3fe86c1a108193"
