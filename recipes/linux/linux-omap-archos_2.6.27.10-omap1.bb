require linux.inc

DESCRIPTION = "Archos 5 Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "archos5it"
#COMPATIBLE_MACHINE = "(archos5|archos5it)"

PV = "2.6.27.10-omap1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.27.tar.bz2;name=kernel \
           http://www.muru.com/linux/omap/patches/patch-2.6.27-omap1.bz2;patch=1;name=patch \
           file://patch-archos-2.6.27-omap1.bz2;patch=1 \
	   file://defconfig"

S = "${WORKDIR}/linux-2.6.27"

SRC_URI[kernel.md5sum] = "b3e78977aa79d3754cb7f8143d7ddabd"
SRC_URI[kernel.sha256sum] = "0e99bf9e83f4d1ae0c656741a84dfddfa9c4d2469cf35475f5939d02dc3e4393"
SRC_URI[patch.md5sum] = "4a3c56484b11438b0a911c432cae08bc"
SRC_URI[patch.sha256sum] = "2cfa3174db86acd9297d9ac641b299c7b8cb7ca6e0f2fb2243a4a5b523ea541c"
