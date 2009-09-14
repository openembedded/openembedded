require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "igep0020"

DEFAULT_PREFERENCE_igep0020 = "1"

SRC_URI = "http://downloads.myigep.com/sources/kernel/linux-omap-2.6.28.10-igep0020b-0.tar.gz \
	   file://defconfig"

S = "${WORKDIR}/linux-omap-2.6.28.10-igep0020b-0"
