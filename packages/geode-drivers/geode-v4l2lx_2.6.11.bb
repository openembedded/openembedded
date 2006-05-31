# V4L2 OE build file for the AMD Geode LX
# Copyright (C) 2005-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "Linux video capture/overlay driver for the AMD Geode LX"
HOMEPAGE = "http://www.amd.com/embedded"
MAINTAINER = "Raymond Danks <info-linux@geode.amd.com>"

PR = "r0"
AMD_DRIVER_VERSION = "03.02.0100"
AMD_DRIVER_LABEL = "Graphics_Video4Linux2_LX_${AMD_DRIVER_VERSION}"

include geode-modules.inc

S="${WORKDIR}/${AMD_DRIVER_LABEL}/lxv4l2"

export EXTRA_CFLAGS += " -DLINUX_2_6=1"