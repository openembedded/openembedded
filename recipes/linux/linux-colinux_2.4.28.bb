SECTION = "kernel"
DESCRIPTION = "User Mode Linux Kernel"
LICENSE = "GPLv2"
COLV = "0.6.1"

COMPATIBLE_MACHINE = "colinux"

#http://internap.dl.sourceforge.net/sourceforge/colinux/coLinux-0.6.1.tar.gz
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.4/linux-${PV}.tar.bz2 \
	   file://colinux-${COLV}.patch;patch=1 \
	   file://nofpu.patch;patch=1 \
	   file://shortloadbytes.patch;patch=1 \
	   file://gcc-registerparanoia.patch;patch=1 \
	   file://linux-2.4.24-attribute-used.patch;patch=1 \
	   file://gcc340-fixes-v2.4.26-try3.patch;patch=1 \
           file://defconfig"

S = "${WORKDIR}/linux-${PV}"

inherit kernel

COMPATIBLE_HOST = "i.86.*-linux"
KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "./${KERNEL_IMAGETYPE}"

do_configure() {
	install -m 0644 ${WORKDIR}/defconfig .config
	kernel_do_configure
}

SRC_URI[md5sum] = "ac7735000d185bc7778c08288760a8a3"
SRC_URI[sha256sum] = "f6639b3861421d522bc0c02f6dec59d92418d27e941fc4e82066a7e1ce23509b"
