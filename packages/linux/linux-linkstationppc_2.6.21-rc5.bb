DESCRIPTION = "Linux Kernel for the Buffalo Linkstation HG 2.6.21-rc5"
SECTION = "kernel"
LICENSE = "GPL"
PR = "r0"

DEPENDS = "dtc-native u-boot-utils-native"
COMPATIBLE_MACHINE = "(lsppchd|lsppchg)"

SRC_URI = "http://kernel.org/pub/linux/kernel/v2.6/linux-2.6.20.tar.bz2 \
	   http://www.kernel.org/pub/linux/kernel/v2.6/testing/patch-2.6.21-rc5.bz2;patch=1 \
	   file://defconfig \
		"

S = "${WORKDIR}/linux-2.6.20"

inherit kernel

export ARCH="powerpc"

KERNEL_IMAGETYPE = "uImage"

FILES_kernel-image += "/boot/kuroboxHG.dtb \
		 /boot/kuroboxHD.dtb"

do_configure() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	ARCH=${ARCH} oe_runmake oldconfig
}

do_install_append() {
	dtc -f -I dts -O dtb -o ${D}/boot/kuroboxHG.dtb -V 16 arch/${ARCH}/boot/dts/kuroboxHG.dts
	dtc -f -I dts -O dtb -o ${D}/boot/kuroboxHD.dtb -V 16 arch/${ARCH}/boot/dts/kuroboxHD.dts
}
KERNEL_IMAGE_SYMLINK_NAME="vmlinux.UBoot"
