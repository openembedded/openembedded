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

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${KV}.tar.bz2;name=kernel \
	http://www.amd.com/files/connectivitysolutions/geode/geode_lx/${AMD_DRIVER_LABEL}.patch;patch=1;name=patch \
	file://defconfig"

do_configure_prepend() {

	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}

SRC_URI[kernel.md5sum] = "f00fd1b5a80f52baf9d1d83acddfa325"
SRC_URI[kernel.sha256sum] = "1fa39c202efe168bfeb0ddd74c8e4814f77da7dc78993e47826bad9173b95808"
SRC_URI[patch.md5sum] = "e26f719ad845910de35ab123e548794b"
SRC_URI[patch.sha256sum] = "7bae2d456ede67312e1b34e4bfc277af7331e0eee55b95226de392e2d4fee340"
