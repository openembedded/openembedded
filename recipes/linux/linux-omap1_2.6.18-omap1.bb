require linux-omap.inc

COMPATIBLE_MACHINE = "omap5912osk"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.18.tar.bz2;name=kernel \
           http://www.muru.com/linux/omap/patches/patch-2.6.18-omap1.bz2;patch=1;name=patch \
           file://another-ide-cs-ids.patch;patch=1 \
	   file://defconfig"

S = "${WORKDIR}/linux-2.6.18"

SRC_URI[kernel.md5sum] = "296a6d150d260144639c3664d127d174"
SRC_URI[kernel.sha256sum] = "c95280ff6c5d2a17788f7cc582d23ae8a9a7ba3f202ec6e4238eaadfce7c163d"
SRC_URI[patch.md5sum] = "955088e5139ef5914d44fe15b4a50b90"
SRC_URI[patch.sha256sum] = "924c27b95f0c3792bf3d48ff854ef145e8916452b917067d653f59102f03c0d4"
