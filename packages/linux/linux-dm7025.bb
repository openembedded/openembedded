DESCRIPTION = "Linux kernel for Dreambox DM7025"
LICENSE = "GPL"
PN = "linux-dm7025"
PV = "2.6.12"
PR = "r3"

# note, the rX in the filename is *NOT* the packet revision - it's the patch revision.
SRC_URI = "ftp://ftp.de.kernel.org/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linux-${PV}-dm7025-r1p2.patch.gz;patch=1;pnum=1 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linux-${PV}-dm7025-dvb.patch.gz;patch=1;pnum=1 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linux-${PV}-dm7025-r1pl1.patch.gz;patch=1;pnum=1 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linux-${PV}-dm7025-r1.conf"

S = "${WORKDIR}/linux-${PV}"

inherit kernel

FILES_kernel-image = "/boot/vmlinux.gz /boot/autoexec.bat"

export OS = "Linux"
KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "vmlinux"
KERNEL_OBJECT_SUFFIX = "ko"

do_configure_prepend() {
	oe_machinstall -m 0644 ${WORKDIR}/linux-${PV}-dm7025-r1.conf ${S}/.config
	oe_runmake oldconfig
}

do_install_append () {
	install -d ${D}/boot
	install -m 0755 vmlinux ${D}/boot/vmlinux
	echo "/flash/bootlogo.elf" > ${D}/boot/autoexec.bat
	gzip ${D}/boot/vmlinux
	echo "/flash/vmlinux.gz" >> ${D}/boot/autoexec.bat
}

pkg_postinst_kernel () {
	true
}

pkg_postrm_kernel () {
	true
}
