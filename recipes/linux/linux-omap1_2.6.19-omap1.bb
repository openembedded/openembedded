require linux-omap.inc

COMPATIBLE_MACHINE = "omap5912osk"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.19.tar.bz2;name=kernel \
           http://www.muru.com/linux/omap/patches/patch-2.6.19-omap1.bz2;patch=1;name=patch \
           file://another-ide-cs-ids.patch;patch=1 \
           file://i2c-fix.patch;patch=1 \
	   file://defconfig"

S = "${WORKDIR}/linux-2.6.19"

SRC_URI[kernel.md5sum] = "443c265b57e87eadc0c677c3acc37e20"
SRC_URI[kernel.sha256sum] = "c2fd6bcd2b7c1b3d37d64e4d1825703792a75474830a3db7d2dc603a8d392d58"
SRC_URI[patch.md5sum] = "3590e42e1a6ea4676df5b187b830b402"
SRC_URI[patch.sha256sum] = "b7cba2e38e81abb4d1d33c3f7f7c028310b392d5ee1ed5e3b2137e024598d903"
