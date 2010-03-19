# Linux kernel OE build file for the AMD Geode GX processor
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

COMPATIBLE_MACHINE = "geodegx"

KV = "2.4.24"
DESCRIPTION = "Linux kernel for the AMD Geode GX processor"
LICENSE = "GPLv2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.4/linux-${KV}.tar.bz2 \
	http://www.amd.com/files/connectivitysolutions/geode/Patches_Linux_${KV}_1.00.tar.gz \
	file://${WORKDIR}/Patches_Linux_${KV}_1.00/linux-${KV}-geode.patch;patch=1 \
	file://linux-2.4.24-gcc340-fixes.patch;patch=1 \
	file://defconfig"

S = "${WORKDIR}/linux-${KV}"

inherit kernel

ARCH = "i386"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        oe_runmake oldconfig
}
