DESCRIPTION = "Linux kernel for Dreambox DM7020"
LICENSE = "GPL"
PN = "linux-dm600pvr"
PV = "2.6.12"
PR = "r2"

# -rX is the patch revision - it's not related to this package's PR
SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-2.6.12.tar.bz2 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linux-2.6.12-dm600pvr-r2.patch.gz;patch=1;pnum=1"

S = "${WORKDIR}/linux-2.6.12"

inherit kernel

FILES_kernel-image = "/boot/zImage.elf /boot/autoexec.bat"

export OS = "Linux"
ARCH = "ppc"
KERNEL_IMAGETYPE = "zImage"
KERNEL_OUTPUT = "arch/ppc/boot/images/zImage.elf"

do_configure_prepend() {
	oe_machinstall -m 0644 ${S}/arch/ppc/configs/dm600pvr_defconfig ${S}/.config || die "no default configuration for ${MACHINE} available."
	oe_runmake oldconfig
}

do_install_append () {
	install -d ${D}/boot
	install -m 0755 arch/ppc/boot/images/zImage.elf ${D}/boot/zImage.elf
	echo "/flash/bootlogo.elf" > ${D}/boot/autoexec.bat
	echo "/flash/zImage.elf" >> ${D}/boot/autoexec.bat
}

pkg_postinst_kernel () {
	true
}

pkg_postrm_kernel () {
	true
}

