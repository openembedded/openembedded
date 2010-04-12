SECTION = "kernel"
DESCRIPTION = "Linux kernel for VIA EPiA"
LICENSE = "GPLv2"
PR = "r0"

KERNEL_CCSUFFIX = "-3.3.4"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
	   http://hem.bredband.net/ekmlar/patch-vt1211-2.6.txt;patch=1;name=patch \
           file://epia_defconfig"
S = "${WORKDIR}/linux-${PV}"

COMPATIBLE_HOST = 'i.86.*-linux'

inherit kernel

ARCH = "i386"

# Don't want kernel in rootfs
FILES_kernel = ""
ALLOW_EMPTY_kernel = "1"
PACKAGES += "kernel-image"
FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}*"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/epia_defconfig ${S}/.config
}

SRC_URI[kernel.md5sum] = "f00fd1b5a80f52baf9d1d83acddfa325"
SRC_URI[kernel.sha256sum] = "1fa39c202efe168bfeb0ddd74c8e4814f77da7dc78993e47826bad9173b95808"
SRC_URI[patch.md5sum] = "cb7f4038723f5d4552bc110479538b13"
SRC_URI[patch.sha256sum] = "4e78c478ebe7666d47a0f86f75fff7680df5cf0ecf134ef98ccad38aaa7b0236"
