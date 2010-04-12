require linux-omap.inc

COMPATIBLE_MACHINE = "omap5912osk"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.24.tar.bz2;name=kernel \
           http://www.muru.com/linux/omap/patches/patch-2.6.24-omap1.bz2;patch=1;name=patch \
           file://binutils-buildid-arm.patch;patch=1 \
           file://timespec_add_ns_avoid_udivdi3.patch;patch=1 \
	   file://defconfig"

S = "${WORKDIR}/linux-2.6.24"

SRC_URI[kernel.md5sum] = "3f23ad4b69d0a552042d1ed0f4399857"
SRC_URI[kernel.sha256sum] = "413c64fbbcf81244cb5571be4963644a1e81166a2b0f008a016528363b65c5d3"
SRC_URI[patch.md5sum] = "a59a24781889452ee6cdd585610a0666"
SRC_URI[patch.sha256sum] = "0f80b2e74c666b989faefd8afb789f3ece4b251ab3902c3e0301733fbb6fba91"
