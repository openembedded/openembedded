DESCRIPTION = "Linux kernel for MTX-1 (MeshCube)"
HOMEPAGE = "http://meshcube.org/meshwiki/"
LICENSE = "GPLv2"
KV = "${PV}"
PR = "r11"
inherit module-base kernel

PROVIDES = "virtual/kernel"
RDEPENDS = "mtd-utils"

SRC_URI = "cvs://cvs:cvs@ftp.linux-mips.org/home/cvs;module=linux;tag=linux_2_4_27 \
	file://01-mtd-2004-01-27.diff;patch=1 \
	file://02-mtd-mtx-1-map.diff;patch=1 \
	file://03-mtd-erase-compiler-bug.diff;patch=1 \
	file://04-mtx-1-board-reset.diff;patch=1 \
	file://05-mtx-1-pci-irq.diff;patch=1 \
	file://06-zboot-2.4.26.patch;patch=1 \
	file://07-zboot-zimage-flash-bin.diff;patch=1 \
	file://08-usb-nonpci-2.4.24.patch;patch=1 \
	file://09-au1000-eth-vlan.diff;patch=1 \
	file://10-iw-max-spy-32.diff;patch=1 \
	file://11-mtd-proc-partition-rw.diff;patch=1 \
	file://12-openswan-2.2.0-nat-t.diff;patch=1 \
	file://13-openswan-2.2.0.patch;patch=1 \
	file://14-au1000-eth-link-beat.diff;patch=1 \
	file://16-i2c.patch;patch=1 \
	file://17-lmsensors.2.8.8.patch;patch=1 \
	file://18-i2c-au1x00gpio.patch;patch=1 \
	file://19-kernel-make-depend.diff;patch=1 \
	file://20-au1x00_ethernet_tx_stats.diff;patch=1 \
	file://21-mtx-1-watchdog.diff;patch=1 \
	file://23-mtx-1_watchdog_autotrigger.patch;patch=1 \
	file://24-mtx-1_sysbtn.patch;patch=1 \
	file://25-mtx-sio2.diff;patch=1 \
	file://26-usbd-amd-pb1x00-kit-23may2003-update.diff;patch=1 \
	file://27-usbd-amd-pb1x00-kit-23may2003-usbd.diff;patch=1 \
	file://29-au1000-pci-config-clear-errors.diff;patch=1 \
	file://32-usbserial-stalled-hack.diff;patch=1 \
	file://33-usbserial-bulk_in_size-4096.diff;patch=1 \
	file://42-usb-ohci-fixes.patch;patch=1 \
	file://43-usbserial-27-32-backport.diff;patch=1 \
	file://45-acm-tty-and-sb2.patch;patch=1 \
	file://48-pptp.patch;patch=1 \
	file://49-bash4-configure.patch;patch=1 \
	file://defconfig-mtx-1"

S = "${WORKDIR}/linux"

inherit kernel

COMPATIBLE_MACHINE = "mtx-1"
COMPATIBLE_HOST = "mipsel.*-linux"
ARCH = "mips"
KERNEL_OUTPUT = "arch/mips/zboot/images/mtx-1.flash.bin"
KERNEL_IMAGETYPE = "zImage.flash"
KERNEL_IMAGEDEST = "tmp"

MTX_KERNEL_NON_PCI_OHCI = "yes"

do_configure_prepend() {
        install -m 0644 ${WORKDIR}/defconfig-mtx-1 ${S}/.config
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
	install -d 0755 ${DEPLOY_DIR_IMAGE}
	install -m 0644 arch/mips/zboot/images/mtx-1.flash.bin ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_NAME}.flash.bin
        install -m 0644 arch/mips/zboot/images/mtx-1.flash.srec ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_NAME}.flash.srec
	install -m 0644 arch/mips/zboot/images/mtx-1.srec ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_NAME}.ram.srec
}
