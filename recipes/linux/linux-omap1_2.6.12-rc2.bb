require linux-omap.inc

PR = "r4"

COMPATIBLE_MACHINE = "omap5912osk"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/v2.6.12/linux-2.6.12-rc2.tar.bz2;name=kernel \
           http://www.muru.com/linux/omap/patches/old/patch-2.6.12-rc2-omap1.bz2;patch=1;name=patch \
	   file://defconfig"

S = "${WORKDIR}/linux-2.6.12-rc2"

SRC_URI[kernel.md5sum] = "b8b75ddeca0f48221f085703f2f72692"
SRC_URI[kernel.sha256sum] = "2e36150665e7268d5dd03b70621a0e80c4f7abb04584694dba540774030f6a54"
SRC_URI[patch.md5sum] = "39df92d9fa916779ab5e596c21c51081"
SRC_URI[patch.sha256sum] = "f3d8a74aee678e9d941fe4335d87b481a39fc568c761916dcc05f0cc8e536837"
