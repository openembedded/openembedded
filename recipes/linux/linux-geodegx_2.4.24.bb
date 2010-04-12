# Linux kernel OE build file for the AMD Geode GX processor
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

COMPATIBLE_MACHINE = "geodegx"

KV = "2.4.24"
DESCRIPTION = "Linux kernel for the AMD Geode GX processor"
LICENSE = "GPLv2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.4/linux-${KV}.tar.bz2;name=kernel \
	http://www.amd.com/files/connectivitysolutions/geode/Patches_Linux_${KV}_1.00.tar.gz;name=patch \
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

SRC_URI[kernel.md5sum] = "1e055c42921b2396a559d84df4c3d9aa"
SRC_URI[kernel.sha256sum] = "9a6c37e048376cd2a9845f6f75cb44fb27c244d719e9d9dd81063a525f081e1f"
# This is from checksums.ini
SRC_URI[patch.md5sum] = "5e47d51daf090c25635cf2c3597150bc"
SRC_URI[patch.sha256sum] = "5194ae0f07aaf274e46712cd3f2be553ca75970d2124ac388ce444adee5e2878"
# CHECKSUMS.INI MISMATCH: I got this instead:
#SRC_URI[patch.md5sum] = "87c2098e64b751f57dc1f4cd8a5b1575"
#SRC_URI[patch.sha256sum] = "56094f8eebbdea160d82af6847aded27e7c53cefec1b00a8e0843c697ba888e4"
