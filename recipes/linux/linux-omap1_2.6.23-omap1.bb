require linux-omap.inc

COMPATIBLE_MACHINE = "omap5912osk"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.23.tar.bz2;name=kernel \
           http://www.muru.com/linux/omap/patches/patch-2.6.23-omap1.bz2;patch=1;name=patch \
           file://binutils-buildid-arm.patch;patch=1 \
	   file://defconfig"

S = "${WORKDIR}/linux-2.6.23"

SRC_URI[kernel.md5sum] = "2cc2fd4d521dc5d7cfce0d8a9d1b3472"
SRC_URI[kernel.sha256sum] = "d4e67c0935ffb2a4158234bff92cc791b83177866009fc9b2214104e0038dbdb"
SRC_URI[patch.md5sum] = "d23e6c5bb8294d61f0d9a4957c22eb20"
SRC_URI[patch.sha256sum] = "c2085fc8fc6df586ef8c19a4562b84162f0b77956d691aa4fbee5e90c9800cb7"
