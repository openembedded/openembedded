# Linux kernel modules OE build files for the AMD Geode GX5535/LX5536
# Copyright (C) 2005-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

LICENSE = "GPL"
HOMEPAGE = "http://www.amd.com/embedded"
MAINTAINER = "Raymond Danks <info-linux@geode.amd.com>"

inherit autotools module-base

export ARCH="i386"

DEPENDS += " virtual/kernel"

S="${WORKDIR}/${AMD_DRIVER_LABEL}"

PACKAGES="${PN}"
FILES_${PN} = "/lib"

KERNEL_SOURCE = ${@base_read_file('${STAGING_KERNEL_DIR}/kernel-source')}

EXTRA_OECONF="--with-kernel-path=${KERNEL_SOURCE} --with-module-path=${D}/lib/modules"

SRC_URI = "http://www.amd.com/files/connectivitysolutions/geode/geode_lx/${AMD_DRIVER_LABEL}.tar.gz"
