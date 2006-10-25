require linux-omap1.inc

PR = "r4"

SRC_URI = "http://www.kernel.org/pub/linux/kernel/v2.6/testing/linux-2.6.12-rc2.tar.bz2 \
           http://www.muru.com/linux/omap/patches/patch-2.6.12-rc2-omap1.bz2;patch=1 \
	   file://defconfig"

S = "${WORKDIR}/linux-2.6.12-rc2"

KERNEL_RELEASE = "2.6.12-rc2-omap1"
