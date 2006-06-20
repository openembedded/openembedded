DESCRIPTION = "Linux kernel for Dreambox DM7025"
LICENSE = "GPL"
PN = "linux-dm7025"
KV = "2.6.12"
PV = "2.6.12.6"
PR = "r5"

# note, the rX in the filename is *NOT* the packet revision - it's the patch revision.
SRC_URI += "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linuxmips-${KV}-dream-r6.patch.bz2;patch=1;pnum=1 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linux-${KV}-update_dvbapi-r1.patch.bz2;patch=1;pnum=1 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linuxmips-${KV}-dm7025-r4.conf \
	http://dreamboxupdate.com/download/kernel-patches/linux-2.6.12-dvb-multipid-r3.patch.bz2;patch=1;pnum=1"

S = "${WORKDIR}/linux-${PV}"

inherit kernel

FILES_kernel-image = "/boot/vmlinux.gz /boot/autoexec.bat"

export OS = "Linux"
KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "vmlinux"
KERNEL_OBJECT_SUFFIX = "ko"

do_configure_prepend() {
	oe_machinstall -m 0644 ${WORKDIR}/linuxmips-${KV}-dm7025-r4.conf ${S}/.config
	oe_runmake oldconfig
}

do_install_append () {
	install -d ${D}/boot
	install -m 0755 vmlinux ${D}/boot/vmlinux
	echo "/flash/bootlogo.elf" > ${D}/boot/autoexec.bat
	gzip ${D}/boot/vmlinux
	echo "/flash/vmlinux.gz" >> ${D}/boot/autoexec.bat
}

pkg_preinst_kernel-image () {
	[ -d /proc/stb ] && mount -o rw,remount /boot
}

pkg_postinst_kernel-image () {
	[ -d /proc/stb ] && mount -o ro,remount /boot
}

pkg_prerm_kernel-image () {
	[ -d /proc/stb ] && mount -o rw,remount /boot
}

pkg_postrm_kernel-image () {
	[ -d /proc/stb ] && mount -o ro,remount /boot
}
