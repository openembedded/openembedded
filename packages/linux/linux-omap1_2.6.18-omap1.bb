require linux-omap1.inc

SRC_URI = "http://www.kernel.org/pub/linux/kernel/v2.6/linux-2.6.18.tar.bz2 \
           http://www.muru.com/linux/omap/patches/patch-2.6.18-omap1.bz2;patch=1 \
           file://another-ide-cs-ids.patch;patch=1 \
	   file://defconfig \
	   file://defconfig.eabi"

S = "${WORKDIR}/linux-2.6.18"

KERNEL_RELEASE = "${PV}"
