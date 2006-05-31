# ALSA OE build file for the AMD Geode 5535/5536
# Copyright (C) 2005-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "Linux 2.6.11 ALSA Audio Driver for the AMD Geode 5535/5536 companion chip"
HOMEPAGE = "http://www.amd.com/embedded"
MAINTAINER = "Raymond Danks <info-linux@geode.amd.com>"

PR = "r0"
AMD_DRIVER_VERSION = "1.00.0500"
AMD_DRIVER_LABEL = "Audio_LinuxALSA_5536_${AMD_DRIVER_VERSION}"

include geode-modules.inc