require linux-omap.inc

COMPATIBLE_MACHINE = "omap5912osk"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.25.tar.bz2;name=kernel \
           http://www.muru.com/linux/omap/patches/patch-2.6.25-omap1.bz2;patch=1;name=patch \
	   file://gcc43-arm-fix-inline-asm-constraints-for-preload.patch;patch=1 \
	   file://defconfig"

S = "${WORKDIR}/linux-2.6.25"

SRC_URI[kernel.md5sum] = "db95a49a656a3247d4995a797d333153"
SRC_URI[kernel.sha256sum] = "108b2a3f2b05c0e57d1d0977619525e46f8d4b425aef4b38b47dcf94292f2dd2"
SRC_URI[patch.md5sum] = "b0aac48e4528aa1fa2b6759f53508643"
SRC_URI[patch.sha256sum] = "6ae71591d0184debcafb134896577447574c8b29545af6e99f6ff09dc3448571"
