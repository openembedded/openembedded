SECTION = "kernel"
DESCRIPTION = "Linux kernel for MTX-1 (MeshCube)"
LICENSE = "GPL"
KV = "${PV}"
RDEPENDS_${PN} = "mtd-utils"
PR = "r3"

SRC_URI = "cvs://cvs:cvs@ftp.linux-mips.org/home/cvs;module=linux;tag=linux_2_4_24_pre2 \
	file://01-mtd-2004-01-27.diff \
	file://02-mtd-mtx-1-map.diff \
	file://03-mtd-erase-compiler-bug.diff \
	file://04-zboot-2.4.24.patch \
	file://05-zboot-cflags.diff \
	file://06-zboot-mtx.diff \
	file://07-zimage-flash-bin.patch \
	file://08-usb-nonpci-2.4.24.patch \
	file://09-iw-max-spy-32.diff \
	file://10-mtx-pci-slots.diff \
	file://11-mtx-extraversion.diff \
	file://12-openswan-2.2.0-nat-t.diff \
	file://13-openswan-2.2.0.patch \
	file://14-au1000-eth-vlan.diff \
	file://15-mtd-proc-partition-rw.diff \
	file://defconfig-mtx-1"

S = "${WORKDIR}/linux"

inherit module-base kernel

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
