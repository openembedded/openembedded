SECTION = "kernel"
DESCRIPTION = "Linux kernel for MTX-1 (MeshCube)"
LICENSE = "GPL"
KV = "${PV}"
RDEPENDS = "mtd-utils"
PR ="r2"

SRC_URI = "cvs://cvs:cvs@ftp.linux-mips.org/home/cvs;module=linux;tag=linux_2_4_24_pre2 \
	file://01-mtd-2004-01-27.diff;apply=yes \
	file://02-mtd-mtx-1-map.diff;apply=yes \
	file://03-mtd-erase-compiler-bug.diff;apply=yes \
	file://04-zboot-2.4.24.patch;apply=yes \
	file://05-zboot-cflags.diff;apply=yes \
	file://06-zboot-mtx.diff;apply=yes \
	file://07-zimage-flash-bin.patch;apply=yes \
	file://08-usb-nonpci-2.4.24.patch;apply=yes \
	file://09-iw-max-spy-32.diff;apply=yes \
	file://10-mtx-pci-slots.diff;apply=yes \
	file://11-mtx-extraversion.diff;apply=yes \
	file://12-openswan-2.2.0-nat-t.diff;apply=yes \
	file://13-openswan-2.2.0.patch;apply=yes \
	file://14-au1000-eth-vlan.diff;apply=yes \
	file://15-mtd-proc-partition-rw.diff;apply=yes \
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
