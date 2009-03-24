DESCRIPTION = "Linux kernel for Dreambox DM8000"
LICENSE = "GPL"
KV = "2.6.12"
PV = "2.6.12"
PR = "r10"

# note, the rX in the filename is *NOT* the packet revision - it's the patch revision.
SRC_URI += "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-${KV}.tar.bz2 \
	file://${MACHINE}_defconfig \
	http://sources.dreamboxupdate.com/download/kernel-patches/linux-2.6.12-brcm-5.1.patch.bz2;patch=1;pnum=1 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linux-2.6.12-update_dvbapi-r1.patch.bz2;patch=1;pnum=1 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linux-2.6.12-dvb-multipid-r4.patch.bz2;patch=1;pnum=1 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linux-2.6.12-dvb-core-fix-several-locking-problems.patch.bz2;patch=1;pnum=1 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linux-2.6.12-dvbapi-pilot-rolloff-extension-r0.patch.bz2;patch=1;pnum=1 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linux-2.6.12-update-wireless.patch.bz2;patch=1;pnum=1 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linux-2.6.12-add-ioprio.patch.bz2;patch=1;pnum=1 \
	file://linux-2.6.12-dvbapi-support-more-demux.patch;patch=1;pnum=1 \
	file://linux-2.6.12-dream-misc.patch;patch=1;pnum=1 \
	file://linux-2.6.12-${MACHINE}-nand.patch;patch=1;pnum=1 \
	file://linux-2.6.12-dream-temp.patch;patch=1;pnum=1 \
	file://linux-2.6.12-brcm-mtd-blkdevfs-fix.diff;patch=1;pnum=1 \
	file://linux-2.6.12-brcm-fix-usb-for-revb0.diff;patch=1;pnum=1 \
	file://linux-2.6.12-set-custom-extraversion.patch;patch=1;pnum=1 \
	file://linux-2.6.12-fixup-prom-args.patch;patch=1;pnum=1 \
	file://linux-2.6.12-7400AB-enable-llsc.patch;patch=1;pnum=1 \
	file://linuxmips-2.6.12-fix-fadvise.patch;patch=1;pnum=1 \
	file://linuxmips-2.6.12-fix-futex.patch;patch=1;pnum=1 \
	file://linuxmips-2.6.12-gcc4-compile-fix.patch;patch=1;pnum=1 \
	file://linuxmips-2.6.12-gdb-fix.patch;patch=1;pnum=1 \
	file://linux-2.6.12-brcm-fix-minipci.patch;patch=1;pnum=1 \
	file://linux-2.6.12-bcmemac-ethtool.patch;patch=1;pnum=1 \
	file://linux-2.6.12-fixup-memsize.patch;patch=1;pnum=1 \
	http://trappist.elis.ugent.be/~mronsse/cdfs/download/cdfs-2.6.12.tar.bz2"

S = "${WORKDIR}/stblinux-2.6.12"

inherit kernel

FILES_kernel-image = "/boot/vmlinux.gz /boot/autoexec.bat"

export OS = "Linux"
KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "vmlinux"
KERNEL_OBJECT_SUFFIX = "ko"

do_munge() {
	mv ${WORKDIR}/linux-2.6.12 ${WORKDIR}/stblinux-2.6.12
	if [ -d ${S}/drivers/sound ]; then
		rm -R ${S}/drivers/sound;
	fi;
}

addtask munge before do_patch after do_unpack

do_configure_prepend() {
	oe_machinstall -m 0644 ${WORKDIR}/${MACHINE}_defconfig ${S}/.config
	if [ -d ${WORKDIR}/cdfs-${PV} ]; then
		mv ${WORKDIR}/cdfs-${PV} ${S}/fs/cdfs
		cd ${S} & patch -p0 < ${S}/fs/cdfs/patch.cdfs
	fi;
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
	true
}

pkg_postinst_kernel-image () {
	[ -d /proc/stb ] && mount -o ro,remount /boot
	true
}

pkg_prerm_kernel-image () {
	[ -d /proc/stb ] && mount -o rw,remount /boot
	true
}

pkg_postrm_kernel-image () {
	[ -d /proc/stb ] && mount -o ro,remount /boot
	true
}
