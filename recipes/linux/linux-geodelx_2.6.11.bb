# Linux kernel OE build file for the AMD Geode GX5535/LX5536
# Copyright (C) 2005-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

COMPATIBLE_MACHINE = "geodelx"

DESCRIPTION = "Linux kernel for the AMD Geode GX5535/LX5536"
HOMEPAGE = "http://www.amd.com/embedded"
LICENSE = "GPLv2"

PR = "r0"
AMD_DRIVER_VERSION = "02.03.0100"
AMD_DRIVER_LABEL = "Patches_Linux2.6.11_Common_${AMD_DRIVER_VERSION}"

KV = "${PV}"

S = "${WORKDIR}/linux-${KV}"

inherit kernel

ARCH = "i386"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${KV}.tar.bz2 \
	http://www.amd.com/files/connectivitysolutions/geode/geode_lx/${AMD_DRIVER_LABEL}.patch;patch=1 \
	file://defconfig"

do_configure_prepend() {

	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}
