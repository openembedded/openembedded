DESCRIPTION = "Linux kernel for MTX-3 (Surfbox3)"
HOMEPAGE = "http://meshcube.org/meshwiki/"
LICENSE = "GPLv2"
KV = "${PV}"
PR = "r11"
inherit module-base kernel

PROVIDES = "virtual/kernel"
RDEPENDS = "mtd-utils"

SRC_URI += "cvs://cvs:cvs@ftp.linux-mips.org/home/cvs;module=linux;tag=linux_2_6_15 \
	file://defconfig-mtx-3"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-mtx-3-${PV}"

S = "${WORKDIR}/linux"

inherit kernel

COMPATIBLE_MACHINE = "mtx-3"
COMPATIBLE_HOST = "arm.*-linux"
ARCH = "arm"
KERNEL_OUTPUT = "arch/arm/zboot/images/mtx-3.flash.bin"
KERNEL_IMAGETYPE = "zImage.flash"
KERNEL_IMAGEDEST = "tmp"

KERNEL_IMAGE_NAME = "kernel-${KV}-${MACHINE}_${BUILDNAME}"

MTX_KERNEL_NON_PCI_OHCI = "no"

PACKAGE_ARCH = "mtx-3"

do_configure_prepend() {
        install -m 0644 ${WORKDIR}/defconfig-mtx-3 ${S}/.config
	if [ "x${MTX_KERNEL_NON_PCI_OHCI}" == "xyes" ]; then
		echo "CONFIG_USB_NON_PCI_OHCI=y" >> ${S}/.config
	fi
}

pkg_postinst_kernel() {
if test "x$D" != "x"; then
	exit 1
else
	if test -e /tmp/zImage.flash-${KV}; then
		echo "*** flashing kernel ***"
		flashcp -v /tmp/zImage.flash-${KV} /dev/mtd/2
		echo "*** done. please reboot ***"
	fi
fi
}

FILES_kernel += " /tmp"

do_deploy() {
        install -d ${DEPLOY_DIR}/images
	install -m 0644 arch/arm/zboot/images/mtx-3.flash.bin ${DEPLOY_DIR}/images/${KERNEL_IMAGE_NAME}.flash.bin
        install -m 0644 arch/arm/zboot/images/mtx-3.flash.srec ${DEPLOY_DIR}/images/${KERNEL_IMAGE_NAME}.flash.srec
	install -m 0644 arch/arm/zboot/images/mtx-3.srec ${DEPLOY_DIR}/images/${KERNEL_IMAGE_NAME}.ram.srec
}
