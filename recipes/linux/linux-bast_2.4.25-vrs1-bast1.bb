SECTION = "kernel"
DESCRIPTION = "Linux kernel for Simtec EB2410ITX"
LICENSE = "GPLv2"
KV = "2.4.25"

KERNEL_CCSUFFIX = "-3.3.3"
COMPATIBLE_HOST = "arm.*-linux"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.4/linux-${KV}.tar.bz2;name=kernel \
           ftp://ftp.arm.linux.org.uk/pub/armlinux/source/kernel-patches/v2.4/patch-2.4.25-vrs1.bz2;patch=1;name=patch1 \
           http://www.simtec.co.uk/products/SWLINUX/files/patch-2.4.25-vrs1-bast1.bz2;patch=1;name=patch2 \
           file://defconfig \
           file://mkdep.patch;patch=1 \
           file://defconfig"
S = "${WORKDIR}/linux-${KV}"

inherit kernel


do_configure_prepend() {
	cp ${WORKDIR}/defconfig ${S}/.config
}

SRC_URI[kernel.md5sum] = "5fc8e9f43fa44ac29ddf9a9980af57d8"
SRC_URI[kernel.sha256sum] = "877af8ed89e56af004bb0662c1a9cfc785b40c602f71a8bf81521991026cf2f0"
SRC_URI[patch1.md5sum] = "ed2909e7dcf11950503e438457086765"
SRC_URI[patch1.sha256sum] = "f7f3c7bb493df1f19da32fd2001a8d52cc6ab3c7286781ebdc4d7d2367debc1d"
SRC_URI[patch2.md5sum] = "1f942ff4ffda9ae764a4e54e7e7935ec"
SRC_URI[patch2.sha256sum] = "3dcee0a8e7ed320396fec2e7eaee380957f3b25350d2f04770e48bf1b724b41d"
