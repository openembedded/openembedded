require linux-omap.inc

COMPATIBLE_MACHINE = "omap5912osk"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.20.tar.bz2;name=kernel \
           http://www.muru.com/linux/omap/patches/patch-2.6.20-omap1.bz2;patch=1;name=patch \
	   file://defconfig"

S = "${WORKDIR}/linux-2.6.20"

SRC_URI[kernel.md5sum] = "34b0f354819217e6a345f48ebbd8f13e"
SRC_URI[kernel.sha256sum] = "2c14ada1ac7d272e03b430d3a530d60fc9ec69cc8252382aa049afba7d2b8558"
SRC_URI[patch.md5sum] = "b220d8b8489003f3df03d897fbefa432"
SRC_URI[patch.sha256sum] = "f85096df0acc179f676497e75b9ba8d9b8685b92b0b2b8b1d6871619ed879fbd"
