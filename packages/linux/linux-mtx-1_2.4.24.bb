SECTION = "kernel"
DESCRIPTION = "Linux kernel for MTX-1 (MeshCube)"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
LICENSE = "GPL"
KV = "${PV}"
RDEPENDS = "mtd-utils"
PR="r2"

SRC_URI = "cvs://cvs:cvs@ftp.linux-mips.org/home/cvs;module=linux;tag=linux_2_4_24_pre2 \
	file://01-mtd-2004-01-27.diff;patch=1 \
	file://02-mtd-mtx-1-map.diff;patch=1 \
	file://03-mtd-erase-compiler-bug.diff;patch=1 \
	file://04-zboot-2.4.24.patch;patch=1 \
	file://05-zboot-cflags.diff;patch=1 \
	file://06-zboot-mtx.diff;patch=1 \
	file://07-zimage-flash-bin.patch;patch=1 \
	file://08-usb-nonpci-2.4.24.patch;patch=1 \
	file://09-iw-max-spy-32.diff;patch=1 \
	file://10-mtx-pci-slots.diff;patch=1 \
	file://11-mtx-extraversion.diff;patch=1 \
	file://12-openswan-2.2.0-nat-t.diff;patch=1 \
	file://13-openswan-2.2.0.patch;patch=1 \
	file://14-au1000-eth-vlan.diff;patch=1 \
	file://15-mtd-proc-partition-rw.diff;patch=1 \
	file://defconfig-mtx-1"

S = "${WORKDIR}/linux"

inherit kernel

PACKAGE_ARCH = "mtx-1"
ARCH = "mips"
KERNEL_OUTPUT = "arch/mips/zboot/images/mtx-1.flash.bin"
KERNEL_IMAGETYPE = "zImage.flash"
KERNEL_IMAGEDEST = "tmp"

do_configure_prepend() {
        install -m 0644 ${WORKDIR}/defconfig-mtx-1 ${S}/.config
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
	install -m 0644 arch/mips/zboot/images/mtx-1.flash.bin ${DEPLOY_DIR}/images/${MACHINE}-${KV}-${DATETIME}.flash.bin
        install -m 0644 arch/mips/zboot/images/mtx-1.flash.srec ${DEPLOY_DIR}/images/${MACHINE}-${KV}-${DATETIME}.flash.srec
	install -m 0644 arch/mips/zboot/images/mtx-1.srec ${DEPLOY_DIR}/images/${MACHINE}-${KV}-${DATETIME}.ram.srec
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile
