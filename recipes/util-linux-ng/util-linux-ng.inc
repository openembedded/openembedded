DESCRIPTION = "Util-linux-ng is a suite of essential utilities for any Linux system."
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "udev zlib ncurses e2fsprogs-libs virtual/libintl"

inherit autotools

DEFAULT_PREFERENCE = "-1"

# allows for a release candidate
RC ?= ""

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/utils/util-linux-ng/v${PV}/util-linux-ng-${PV}${RC}.tar.bz2"

PACKAGES =+ "util-linux-ng-fdisk util-linux-ng-cfdisk util-linux-ng-sfdisk util-linux-ng-swaponoff util-linux-ng-losetup util-linux-ng-umount util-linux-ng-mount util-linux-ng-readprofile "

FILES_${PN}-doc += "/usr/share/misc/getopt/getopt-*.*"

FILES_util-linux-ng-fdisk = "/sbin/fdisk.${PN}"
FILES_util-linux-ng-cfdisk = "/sbin/cfdisk"
FILES_util-linux-ng-sfdisk = "/sbin/sfdisk"
FILES_util-linux-ng-swaponoff = "/sbin/swapon.${PN} /sbin/swapoff.${PN}"
FILES_util-linux-ng-losetup = "/sbin/losetup.${PN}"
FILES_util-linux-ng-mount = "/bin/mount.${PN} ${sysconfdir}/default/mountall"
FILES_util-linux-ng-umount = "/bin/umount.${PN}"
FILES_util-linux-ng-readprofile = "/usr/sbin/readprofile.${PN}"

RRECOMMENDS_${PN} = "util-linux-ng-fdisk util-linux-ng-cfdisk util-linux-ng-sfdisk util-linux-ng-mount util-linux-ng-readprofile "
RDEPENDS_${PN} = "util-linux-ng-umount util-linux-ng-swaponoff util-linux-ng-losetup"

EXTRA_OECONF = "--disable-use-tty-group --disable-makeinstall-chown \
--enable-kill --enable-last --enable-mesg --enable-raw --enable-login-utils \
--enable-arch --enable-init"

S = "${WORKDIR}/util-linux-ng-${PV}${RC}"

do_compile () {
	set -e
#	install ${WORKDIR}/MCONFIG ${S}/MCONFIG
#	install ${WORKDIR}/make_include ${S}/make_include
#	install ${WORKDIR}/swapargs.h ${S}/mount/swapargs.h
#	install ${WORKDIR}/defines.h ${S}/defines.h
	oe_runmake ARCH=${TARGET_ARCH} CPU= CPUOPT= \
		'OPT=${CFLAGS}' 'CC=${CC}' 'LD=${LD}' \
		'LDFLAGS=${LDFLAGS}'
}

checklink() {
	local targ link value
	targ="$1"
	link="$2"
	ext="$3"
	if test -h "$link"
	then
		value="$(readlink "$link")"
		if test "$value" = "$targ"
		then
			rm "$link"
			ln -s "$targ"."${PN}" "$link$ext"
			return 0
		else
			echo "$link: '$value' found '$targ' expected" >&2
			return 1
		fi
	else
		echo "$link: not a symbolic link" >&2
		return 1
	fi
}

do_install () {
	# with ccache the timestamps on compiled files may
	# end up earlier than on their inputs, this allows
	# for the resultant compilation in the install step.
	oe_runmake ARCH=${TARGET_ARCH} CPU= CPUOPT= \
		'OPT=${CFLAGS}' 'CC=${CC}' 'LD=${LD}' \
		'LDFLAGS=${LDFLAGS}' 'DESTDIR=${D}' install
	mkdir ${D}${base_bindir}
	mkdir ${D}${base_sbindir}
	test -f ${D}${sbindir}/pivot_root && \
	mv ${D}${sbindir}/pivot_root ${D}${base_sbindir}/pivot_root.${PN}
	mv ${D}${bindir}/dmesg ${D}${base_bindir}/dmesg.${PN}
	mv ${D}${bindir}/kill ${D}${base_bindir}/kill.${PN}
	mv ${D}${bindir}/more ${D}${base_bindir}/more.${PN}
	mv ${D}${sbindir}/hwclock ${D}${base_sbindir}/hwclock.${PN}
	mv ${D}${sbindir}/mkswap ${D}${base_sbindir}/mkswap.${PN}
	mv ${D}${sbindir}/shutdown ${D}${base_sbindir}/shutdown.${PN}
#	mv ${D}${sbindir}/sln ${D}${base_sbindir}/sln.${PN}
	mv ${D}${sbindir}/mkfs.minix ${D}${base_sbindir}/mkfs.minix.${PN}
	mv ${D}${sbindir}/fsck.minix ${D}${base_sbindir}/fsck.minix.${PN}
	mv ${D}${bindir}/hexdump ${D}${bindir}/hexdump.${PN}
	mv ${D}${bindir}/last ${D}${bindir}/last.${PN}
	mv ${D}${bindir}/logger ${D}${bindir}/logger.${PN}
	mv ${D}${bindir}/mesg ${D}${bindir}/mesg.${PN}
	mv ${D}${bindir}/renice ${D}${bindir}/renice.${PN}
	mv ${D}${bindir}/wall ${D}${bindir}/wall.${PN}

	mv ${D}${sbindir}/losetup ${D}${base_sbindir}/losetup.${PN}
	mv ${D}${sbindir}/swapon ${D}${base_sbindir}/swapon.${PN}
	mv ${D}${bindir}/umount ${D}${base_bindir}/umount.${PN}
	mv ${D}${bindir}/mount ${D}${base_bindir}/mount.${PN}
	mv ${D}${sbindir}/fdisk ${D}${base_sbindir}/fdisk.${PN}

	mv ${D}${sbindir}/agetty ${D}${base_sbindir}/ 
	mv ${D}${sbindir}/blockdev ${D}${base_sbindir}/
	mv ${D}${sbindir}/cfdisk ${D}${base_sbindir}/
	mv ${D}${sbindir}/ctrlaltdel ${D}${base_sbindir}/

	mv ${D}${sbindir}/readprofile ${D}${sbindir}/readprofile.${PN}
	
	install -d ${D}${sysconfdir}/default/
	echo 'MOUNTALL="-t nonfs,nosmbfs,noncpfs"' > ${D}${sysconfdir}/default/mountall

	ln -sf ${sbindir}/swapon ${D}${sbindir}/swapoff.${PN}
	ln -sf ${sbindir}/shutdown ${D}${sbindir}/reboot.${PN}
	ln -sf ${sbindir}/shutdown ${D}${sbindir}/halt.${PN}
	ln -sf ${sbindir}/shutdown ${D}${sbindir}/fastboot
	ln -sf ${sbindir}/shutdown ${D}${sbindir}/fasthalt
}

pkg_postinst_${PN} () {
	update-alternatives --install ${base_bindir}/dmesg dmesg dmesg.${PN} 100
	update-alternatives --install ${base_bindir}/kill kill kill.${PN} 100
	update-alternatives --install ${base_bindir}/more more more.${PN} 100
	update-alternatives --install ${base_sbindir}/mkswap mkswap mkswap.${PN} 100
	test -x ${base_sbindir}/pivot_root.${PN} && \
	update-alternatives --install ${base_sbindir}/pivot_root pivot_root pivot_root.${PN} 100
	update-alternatives --install ${base_sbindir}/sln sln sln.${PN} 100
	update-alternatives --install ${base_sbindir}/mkfs.minix mkfs.minix mkfs.minix.${PN} 100
	update-alternatives --install ${base_sbindir}/fsck.minix fsck.minix fsck.minix.${PN} 100
	update-alternatives --install ${bindir}/hexdump hexdump hexdump.${PN} 100
	update-alternatives --install ${bindir}/last last last.${PN} 100
	update-alternatives --install ${bindir}/logger logger logger.${PN} 100
	update-alternatives --install ${bindir}/mesg mesg mesg.${PN} 100
	update-alternatives --install ${bindir}/renice renice renice.${PN} 100
	update-alternatives --install ${bindir}/wall wall wall.${PN} 100
	
	# There seems to be problem, atleast on nslu2, with these, until they are
	# fixed the busybox ones have higher priority
	update-alternatives --install ${base_sbindir}/hwclock hwclock hwclock.${PN} 10
	update-alternatives --install ${base_sbindir}/shutdown shutdown shutdown.${PN} 10
	update-alternatives --install ${base_sbindir}/reboot reboot reboot.${PN} 10
	update-alternatives --install ${base_sbindir}/halt halt halt.${PN} 10
}

pkg_prerm_${PN} () {
	test -x ${base_sbindir}/pivot_root.${PN} && \
	update-alternatives --remove pivot_root pivot_root.${PN}
	update-alternatives --remove dmesg dmesg.${PN}
	update-alternatives --remove kill kill.${PN}
	update-alternatives --remove more more.${PN}
	update-alternatives --remove halt halt.${PN}
	update-alternatives --remove hwclock hwclock.${PN}
	update-alternatives --remove mkswap mkswap.${PN}
	update-alternatives --remove reboot reboot.${PN}
	update-alternatives --remove shutdown shutdown.${PN}
	update-alternatives --remove sln sln.${PN}
	update-alternatives --remove mkfs.minix mkfs.minix.${PN}
	update-alternatives --remove fsck.minix fsck.minix.${PN}
	update-alternatives --remove hexdump hexdump.${PN}
	update-alternatives --remove last last.${PN}
	update-alternatives --remove logger logger.${PN}
	update-alternatives --remove mesg mesg.${PN}
	update-alternatives --remove renice renice.${PN}
	update-alternatives --remove wall wall.${PN}
}

pkg_postinst_util-linux-ng-fdisk () {
	update-alternatives --install ${base_sbindir}/fdisk fdisk fdisk.${PN} 100
}

pkg_prerm_util-linux-ng-fdisk () {
	update-alternatives --remove fdisk fdisk.${PN}
}

pkg_postinst_util-linux-ng-mount () {
	update-alternatives --install ${base_bindir}/mount mount mount.${PN} 100
}

pkg_prerm_util-linux-ng-mount () {
	update-alternatives --remove mount mount.${PN}
}

pkg_postinst_util-linux-ng-umount () {
	update-alternatives --install ${base_bindir}/umount umount umount.${PN} 100
}

pkg_prerm_util-linux-ng-umount () {
	update-alternatives --remove umount umount.${PN}
}

pkg_postinst_util-linux-ng-losetup () {
	update-alternatives --install ${base_sbindir}/losetup losetup losetup.${PN} 100
}

pkg_prerm_util-linux-ng-losetup () {
	update-alternatives --remove losetup losetup.${PN}
}

pkg_postinst_util-linux-ng-swaponoff () {
	update-alternatives --install ${base_sbindir}/swapoff swapoff swapoff.${PN} 100
	update-alternatives --install ${base_sbindir}/swapon swapon swapon.${PN} 100
}

pkg_prerm_util-linux-ng-swaponoff () {
	update-alternatives --remove swapoff swapoff.${PN}
	update-alternatives --remove swapon swapon.${PN}
}

pkg_postinst_util-linux-ng-readprofile() {
    update-alternatives --install ${sbindir}/readprofile readprofile readprofile.${PN} 100
}

pkg_prerm_util-linux-ng-readprofile () {
    update-alternatives --remove readprofile readprofile.${PN} 100
}

