# AccessBus OE build file for the AMD Geode 5535/5536
# Copyright (C) 2005-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "Linux Access Bus driver for the AMD Geode 5535/5536"
HOMEPAGE = "http://www.amd.com/embedded"
MAINTAINER = "Raymond Danks <info-linux@geode.amd.com>"

PR = "r0"
AMD_DRIVER_VERSION = "01.00.0401"
AMD_DRIVER_LABEL = "AccessBus_Linux_5536_${AMD_DRIVER_VERSION}"

include geode-modules.inc