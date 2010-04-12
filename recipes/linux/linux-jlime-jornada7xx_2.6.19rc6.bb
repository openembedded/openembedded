SECTION = "kernel"
DESCRIPTION = "JLime Linux kernel for Arm based Jornada 7xx"
LICENSE = "GPLv2"
PR = "r0"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "jornada7xx"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.18.tar.gz;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/v2.6.19/patch-2.6.19-rc6.bz2;patch=1;name=patch \
	   file://jornada7xx.patch;patch=0 \
           file://defconf_jlime "

S = "${WORKDIR}/linux-2.6.18"

inherit kernel

#Lets let 3.4.x handle the compilation of this one
KERNEL_CCSUFFIX = "-3.4.4"

ARCH = "arm"

FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}*"

do_configure_prepend() {
	sed -i 's:\(#include "modpost.h"\):\1\n#include <limits.h>:' ${S}/scripts/mod/sumversion.c
	install -m 0644 ${WORKDIR}/defconf_jlime ${S}/.config
}

SRC_URI[kernel.md5sum] = "bc483723670bda09198d72293e712d42"
SRC_URI[kernel.sha256sum] = "eae56a8a9c788518e88604fff343ce6139cecbc7e44356bf1ff4dc7aaf4e9b33"
SRC_URI[patch.md5sum] = "e786ab1f9c8ee97f054462811a89aaba"
SRC_URI[patch.sha256sum] = "58007ec7430c5d954d2eccd64879797dfbcce68561c9de232cb59aca4fd2c1f4"
