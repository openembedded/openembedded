SECTION = "kernel"
DESCRIPTION = "User Mode Linux Kernel"
LICENSE = "GPLv2"
COLV = "0.6.2"

COMPATIBLE_MACHINE = "colinux"

#http://internap.dl.sourceforge.net/sourceforge/colinux/coLinux-${COLV}.tar.gz
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
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
