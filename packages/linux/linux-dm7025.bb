DESCRIPTION = "Linux kernel for Dreambox DM7025"
LICENSE = "GPL"
PN = "linux-dm7025"
KV = "2.6.12"
PV = "2.6.12.6"
PR = "s2"

DEPENDS = "zlib-native"

# note, the rX in the filename is *NOT* the packet revision - it's the patch revision.
SRC_URI += "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linuxmips-${KV}-dream-r6.patch.bz2;patch=1;pnum=1 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linux-${KV}-update_dvbapi-r1.patch.bz2;patch=1;pnum=1 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linuxmips-${KV}-dm7025-r6.conf \
	http://dreamboxupdate.com/download/kernel-patches/linux-2.6.12-dvb-multipid-r4.patch.bz2;patch=1;pnum=1 \
	http://dreamboxupdate.com/download/kernel-patches/linux-2.6.12-dvb-core-fix-several-locking-problems.patch.bz2;patch=1;pnum=1 \
	http://dreamboxupdate.com/download/kernel-patches/linux-2.6.12-dvbapi-pilot-rolloff-extension-r0.patch.bz2;patch=1;pnum=1 \
	http://sources.dreamboxupdate.com/download/kernel-patches/linux-2.6.12-update-wireless.patch.bz2;patch=1;pnum=1 \
#squashfs-lzma stuff
	http://squashfs-lzma.org/dl/sqlzma3.2-r2b.tar.bz2 \
	http://dreamboxupdate.com/download/kernel-patches/sqlzma2k-3.2-r2-2.6.12.6.patch.bz2 \
	http://dreamboxupdate.com/download/patches/fix_lzma_squashfs_makefiles_for_oe-r2.patch.bz2 \
	${SOURCEFORGE_MIRROR}/squashfs/squashfs3.2-r2.tar.gz \
	${SOURCEFORGE_MIRROR}/sevenzip/lzma443.tar.bz2 \
	file://${WORKDIR}/squashfs-lzma/kernel-patches/linux-2.6.12/squashfs3.2-patch;pnum=1;patch=1 "

S = "${WORKDIR}/linux-${PV}"

inherit kernel

FILES_kernel-image = "/boot/vmlinux.gz /boot/autoexec.bat"

export OS = "Linux"
KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "vmlinux"
KERNEL_OBJECT_SUFFIX = "ko"

addtask munge after do_unpack before do_patch

do_munge () {
	if [ -d ${WORKDIR}/squashfs3.2-r2 ]; then
		mv ${WORKDIR}/squashfs3.2-r2/* ${WORKDIR}
		rm -R ${WORKDIR}/squashfs3.2-r2
		for i in sqlzma1-443.patch sqlzma2u-3.2-r2.patch fix_lzma_squashfs_makefiles_for_oe-r2.patch; 
		do
	    		echo "Applying $i"
			patch -d ${WORKDIR} -p1 < ${WORKDIR}/$i
		done
	fi
	set CUR = `pwd`
	cd ${WORKDIR}
	install -d ${WORKDIR}/squashfs-lzma
	for i in `find -maxdepth 1 | grep -v linux | xargs`; 
	do
		case $i in
			".");;
			"./squashfs-lzma");;
			"./temp");;
			"./image");;
			"./install");;
			*)mv $i ${WORKDIR}/squashfs-lzma;;
		esac
	done
	cd $CUR
}

do_compile_prepend () {
	if [ -f ${S}/.patched ];
	then
		patch -R -d ${S} -p1 < ${WORKDIR}/squashfs-lzma/sqlzma2k-3.2-r2-2.6.12.6.patch
		rm ${S}/.patched
	fi
}

do_compile_append () {
	patch -d ${S} -p1 < ${WORKDIR}/squashfs-lzma/sqlzma2k-3.2-r2-2.6.12.6.patch
	touch ${S}/.patched
	oe_runmake -C ${WORKDIR}/squashfs-lzma KDir=${S} BUILD_CC="${CC}" BUILD_CXX="${CXX}" BUILD_LD="${LD}" BUILD_AR="${AR}" BUILD_LDFLAGS="${TARGET_LDFLAGS}" BUILD_CFLAGS="${TARGET_CFLAGS}" BUILD_CXXFLAGS="${TARGET_CXXFLAGS}"
	for i in mksquashfs unsquashfs; 
	do
		mv ${WORKDIR}/squashfs-lzma/squashfs-tools/$i ${WORKDIR}/squashfs-lzma/squashfs-tools/$i-${ARCH}
	done
	oe_runmake -C ${WORKDIR}/squashfs-lzma KDir=${S} clean
	oe_runmake -C ${WORKDIR}/squashfs-lzma KDir=${S}
	patch -R -d ${S} -p1 < ${WORKDIR}/squashfs-lzma/sqlzma2k-3.2-r2-2.6.12.6.patch
	rm ${S}/.patched
}

do_configure_prepend () {
	if [ "${@bb.data.getVar('DISTRO_VERSION', d, 1)}" == "1.4.0" ];
	then
		cat ${WORKDIR}/linuxmips-${KV}-dm7025-r6.conf | grep -v "CONFIG_CMDLINE" > ${S}/.config
		echo "CONFIG_CMDLINE=\"console=null root=/dev/mtdblock3 rootfstype=jffs2 rw\"" >> ${S}/.config
	else
		oe_machinstall -m 0644 ${WORKDIR}/linuxmips-${KV}-dm7025-r6.conf ${S}/.config
	fi;
	oe_runmake oldconfig
}

do_install_append () {
	install -d ${D}/boot
	install -m 0755 vmlinux ${D}/boot/vmlinux
	echo "/flash/bootlogo.elf" > ${D}/boot/autoexec.bat
	gzip ${D}/boot/vmlinux
	echo "/flash/vmlinux.gz" >> ${D}/boot/autoexec.bat
	for i in sqlzma.ko unlzma.ko; 
	do 
		install -m 0644 ${WORKDIR}/squashfs-lzma/C/7zip/Compress/LZMA_C/kmod/$i ${D}/lib/modules/2.6.12.6/kernel/fs/squashfs
	done;
	install -d ${D}/usr/bin
	for i in mksquashfs unsquashfs;
	do
		install ${WORKDIR}/squashfs-lzma/squashfs-tools/$i-${ARCH} ${D}/usr/bin/$i
	done;
}

PACKAGES_append = " unsquashfs mksquashfs"
FILES_mksquashfs = "/usr/bin/mksquashfs"
FILES_unsquashfs = "/usr/bin/unsquashfs"

do_stage_append() {
	install ${WORKDIR}/squashfs-lzma/C/7zip/Compress/LZMA_Alone/lzma ${STAGING_BINDIR}
	install ${WORKDIR}/squashfs-lzma/C/7zip/Compress/LZMA_C/lzmadec ${STAGING_BINDIR}
	install ${WORKDIR}/squashfs-lzma/squashfs-tools/mksquashfs ${STAGING_BINDIR}
	install ${WORKDIR}/squashfs-lzma/squashfs-tools/unsquashfs ${STAGING_BINDIR}
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
