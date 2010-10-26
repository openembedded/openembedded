DESCRIPTION = "Linux kernel for MTX-2 (Surfbox2)"
HOMEPAGE = "http://meshcube.org/meshwiki/"
LICENSE = "GPLv2"
KV = "${PV}"
PR = "r12"
inherit module-base kernel

PROVIDES = "virtual/kernel"
RDEPENDS_${PN} = "mtd-utils"

SRC_URI += "cvs://cvs:cvs@ftp.linux-mips.org/home/cvs;module=linux;tag=linux_2_4_27 \
	file://00-mtx-2.diff \
	file://01-mtd-mtx-2.diff \
	file://03-mtd-erase-compiler-bug.diff \
	file://04-mtd-yamonenv-readwrite.diff \
	file://05-mtx-2-pci-irq.diff \
	file://06-zboot-2.4.26.patch \
	file://07-zboot-zimage-flash-bin.diff \
	file://08-usb-nonpci-2.4.24.patch \
	file://10-iw-max-spy-32.diff \
	file://11-mtd-proc-partition-rw.diff \
	file://12-openswan-2.2.0-nat-t.diff \
	file://13-openswan-2.2.0.patch \
	file://16-i2c.patch \
	file://17-lmsensors.2.8.8.patch \
	file://18-i2c-au1x00gpio.patch \
	file://19-kernel-make-depend.diff \
	file://22-umts.diff \
	file://27-idsel-cardbus.diff \
	file://28-surfbox2-idsel.diff \
	file://29-au1000-pci-config-clear-errors.diff \
	file://32-usbserial-stalled-hack.diff \
	file://33-usbserial-bulk_in_size-4096.diff \
	file://35-sb2-slic.patch \
	file://36-sb2-lcd.patch \
	file://37-sb2-sysbtn.patch \
	file://39-mppe-mpc.patch \
	file://40-option-hsdpa.patch \
	file://42-usb-ohci-fixes.patch \
	file://43-usbserial-27-32-backport.diff \
	file://44-dbdma-and-au1550_psc.diff \
	file://45-acm-tty-and-sb2.patch \
	file://46-otg.patch \
	file://47-au1000_eth.patch \
	file://48-pptp.patch \
	file://49-bash4-configure.patch \
	file://defconfig-mtx-2"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-mtx-2-${PV}"

S = "${WORKDIR}/linux"

inherit kernel

COMPATIBLE_MACHINE = "mtx-2"
COMPATIBLE_HOST = "mipsel.*-linux"
ARCH = "mips"
KERNEL_OUTPUT = "arch/mips/zboot/images/mtx-2.flash.bin"
KERNEL_IMAGETYPE = "zImage.flash"
KERNEL_IMAGEDEST = "tmp"

KERNEL_IMAGE_NAME = "kernel-${KV}-${MACHINE}_${BUILDNAME}"

MTX_KERNEL_NON_PCI_OHCI = "no"

PACKAGE_ARCH = "mtx-2"

do_configure_prepend() {
        install -m 0644 ${WORKDIR}/defconfig-mtx-2 ${S}/.config
	if [ "x${MTX_KERNEL_NON_PCI_OHCI}" = "xyes" ]; then
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
	install -d 0755 ${DEPLOY_DIR_IMAGE}
	install -m 0644 arch/mips/zboot/images/mtx-2.flash.bin ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_NAME}.flash.bin
        install -m 0644 arch/mips/zboot/images/mtx-2.flash.srec ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_NAME}.flash.srec
	install -m 0644 arch/mips/zboot/images/mtx-2.srec ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_NAME}.ram.srec
}
