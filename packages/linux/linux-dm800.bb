DESCRIPTION = "Linux kernel for Dreambox DM8000"
LICENSE = "GPL"
PN = "linux-dm800"
KV = "2.6.12"
PV = "2.6.12"
PR = "r2"

# note, the rX in the filename is *NOT* the packet revision - it's the patch revision.
SRC_URI += "http://sources.dreamboxupdate.com/download/kernel-patches/stblinux-2.6.12-5.0.tar.bz2 \
	file://dm800_defconfig \
	file://linuxmips-2.6.12-dream-r6.patch;patch=1;pnum=1 \
	file://linux-2.6.12-update_dvbapi-r1.patch;patch=1;pnum=1 \
	file://linux-2.6.12-dvb-multipid-r4.patch;patch=1;pnum=1 \
	file://linux-2.6.12-dream-temp.patch;patch=1;pnum=1 \
	file://linux-2.6.12-brcm-mtd-blkdevfs-fix.diff;patch=1;pnum=1 \
	file://linux-2.6.12-dm800-flash-layout.patch;patch=1;pnum=1 \
	file://linux-2.6.12-set-custom-extraversion.patch;patch=1;pnum=1 \
	file://linux-2.6.12-7401C0-enable-llsc.patch;patch=1;pnum=1 \
	file://linux-2.6.12-fixup-prom-args.patch;patch=1;pnum=1"

S = "${WORKDIR}/stblinux-2.6.12"

inherit kernel

FILES_kernel-image = "/boot/vmlinux.gz /boot/autoexec.bat"

export OS = "Linux"
KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "vmlinux"
KERNEL_OBJECT_SUFFIX = "ko"

do_munge() {
	if [ -d ${S}/drivers/sound ]; then
		rm -R ${S}/drivers/sound;
	fi;
}

addtask munge before do_patch after do_unpack

do_configure_prepend() {
	oe_machinstall -m 0644 ${WORKDIR}/dm800_defconfig ${S}/.config
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
