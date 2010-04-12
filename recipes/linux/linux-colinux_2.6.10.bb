SECTION = "kernel"
DESCRIPTION = "User Mode Linux Kernel"
LICENSE = "GPLv2"
COLV = "0.6.2"

COMPATIBLE_MACHINE = "colinux"

#http://internap.dl.sourceforge.net/sourceforge/colinux/coLinux-${COLV}.tar.gz
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
	   file://colinux-${COLV}.patch;patch=1 \
	   file://defconfig"

S = "${WORKDIR}/linux-${PV}"

inherit kernel

COMPATIBLE_HOST = "i.86.*-linux"
KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "./${KERNEL_IMAGETYPE}"

do_configure() {
	echo '-co-${COLV}' > localversion-cooperative
	install -m 0644 ${WORKDIR}/defconfig .config
	kernel_do_configure
}

SRC_URI[kernel.md5sum] = "cffcd2919d9c8ef793ce1ac07a440eda"
SRC_URI[kernel.sha256sum] = "21646736755faee214f489b7388e6c47f5bcf6c2df64298ed2597104fabb8f0e"
