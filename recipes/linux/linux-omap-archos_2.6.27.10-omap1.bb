require linux.inc

DESCRIPTION = "Archos 5 Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "archos5it"
#COMPATIBLE_MACHINE = "(archos5|archos5it)"

PV = "2.6.27.10-omap1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.27.tar.bz2 \
           http://www.muru.com/linux/omap/patches/patch-2.6.27-omap1.bz2;patch=1 \
           file://patch-archos-2.6.27-omap1.bz2;patch=1 \
	   file://defconfig"

S = "${WORKDIR}/linux-2.6.27"
