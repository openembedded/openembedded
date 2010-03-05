DESCRIPTION = "Util-linux-ng is a suite of essential utilities for any Linux system."
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "udev zlib ncurses virtual/libintl"

inherit autotools

DEFAULT_PREFERENCE = "-1"

INC_PR = "r12"

# allows for a release candidate
RC ?= ""

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/utils/util-linux-ng/v${PV}/util-linux-ng-${PV}${RC}.tar.bz2"

SRC_URI_append_chinook-compat = " file://chinook_libtool.patch;patch=1 "

PACKAGES =+ "util-linux-ng-fdisk util-linux-ng-cfdisk util-linux-ng-sfdisk util-linux-ng-swaponoff util-linux-ng-losetup util-linux-ng-umount util-linux-ng-mount util-linux-ng-readprofile "
PACKAGES_DYNAMIC = "libblkid*"

# Provide old util-linux names (several recipes still use DEPENDS or RDEPENDS = "util-linux"):
PROVIDES = "util-linux"
RPROVIDES_${PN} = "util-linux"
RPROVIDES_util-linux-ng-fdisk = "util-linux-fdisk"
RPROVIDES_util-linux-ng-cfdisk = "util-linux-cfdisk"
RPROVIDES_util-linux-ng-sfdisk = "util-linux-sfdisk"
RPROVIDES_util-linux-ng-swaponoff = "util-linux-swaponoff"
RPROVIDES_util-linux-ng-losetup = "util-linux-losetup"
RPROVIDES_util-linux-ng-umount = "util-linux-umount"
RPROVIDES_util-linux-ng-mount = "util-linux-mount"
RPROVIDES_util-linux-ng-readprofile = "util-linux-readprofile"

FILES_${PN}-doc += "/usr/share/misc/getopt/getopt-*.*"
FILES_${PN} = "${bindir} ${sbindir} ${base_bindir} ${base_sbindir}"

FILES_util-linux-ng-fdisk = "${base_sbindir}/fdisk.${PN}"
FILES_util-linux-ng-cfdisk = "${base_sbindir}/cfdisk"
# Moved to ${sbindir} in new versions:
FILES_util-linux-ng-sfdisk = "${base_sbindir}/sfdisk ${sbindir}/sfdisk"
FILES_util-linux-ng-swaponoff = "${base_sbindir}/swapon.${PN} ${base_sbindir}/swapoff.${PN}"
FILES_util-linux-ng-losetup = "${base_sbindir}/losetup.${PN}"
FILES_util-linux-ng-mount = "${base_bindir}/mount.${PN} ${sysconfdir}/default/mountall"
FILES_util-linux-ng-umount = "${base_bindir}/umount.${PN}"
# Moved to ${base_sbindir} by do_install:
FILES_util-linux-ng-readprofile = "${base_sbindir}/readprofile.${PN}"

PACKAGES =+ "${PN}-mountall"
FILES_${PN}-mountall = "${sysconfdir}/default/mountall"
RREPLACES_${PN}-mountall = "busybox-mountall"

RRECOMMENDS_${PN} = "util-linux-ng-fdisk util-linux-ng-cfdisk util-linux-ng-sfdisk util-linux-ng-mount util-linux-ng-readprofile "
RDEPENDS_${PN} = "${PN}-mountall util-linux-ng-umount util-linux-ng-swaponoff util-linux-ng-losetup"

EXTRA_OECONF = "--disable-use-tty-group --disable-makeinstall-chown \
--enable-kill --enable-last --enable-mesg --enable-raw --enable-login-utils \
--enable-arch --enable-init --enable-partx --enable-schedutils \
--with-fsprobe=builtin"

S = "${WORKDIR}/util-linux-ng-${PV}${RC}"

do_configure_prepend_chinook-compat () {

        for i in  lt~obsolete.m4 ltsugar.m4 libtool.m4 ltoptions.m4 ltversion.m4
        do
                rm ${S}/m4/${i}
        done
}

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
	mkdir -p ${D}${base_bindir}

        sbinprogs="agetty blockdev ctrlaltdel cfdisk vipw vigr"
        sbinprogs_a="pivot_root hwclock mkswap shutdown mkfs.minix fsck.minix losetup swapon fdisk readprofile"
        usrbinprogs_a="chfn chsh hexdump last logger mesg newgrp renice wall"
        binprogs_a="dmesg kill more umount mount login"

        if [ "${base_sbindir}" != "${sbindir}" ]; then
        	mkdir -p ${D}${base_sbindir}
                for p in $sbinprogs $sbinprogs_a; do
                        if [ -f "${D}${sbindir}/$p" ]; then
                                mv "${D}${sbindir}/$p" "${D}${base_sbindir}/$p"
                        fi
                done
        fi

        if [ "${base_bindir}" != "${bindir}" ]; then
        	mkdir -p ${D}${base_bindir}
                for p in $binprogs_a; do
                        if [ -f "${D}${bindir}/$p" ]; then
                                mv "${D}${bindir}/$p" "${D}${base_bindir}/$p"
                        fi
                done
        fi

        for p in $usrbinprogs_a; do
                if [ -f "${D}${bindir}/$p" ]; then
                        mv "${D}${bindir}/$p" "${D}${bindir}/$p.${PN}"
                fi
        done

        for p in $binprogs_a; do
                if [ -f "${D}${base_bindir}/$p" ]; then
                        mv "${D}${base_bindir}/$p" "${D}${base_bindir}/$p.${PN}"
                fi
        done

        for p in $sbinprogs_a; do
                if [ -f "${D}${base_sbindir}/$p" ]; then
                        mv "${D}${base_sbindir}/$p" "${D}${base_sbindir}/$p.${PN}"
                fi
        done

	install -d ${D}${sysconfdir}/default/
	echo 'MOUNTALL="-t nonfs,nosmbfs,noncpfs"' > ${D}${sysconfdir}/default/mountall

	rm ${D}${sbindir}/swapoff -f
	ln -sf ${base_sbindir}/swapon.${PN} ${D}${base_sbindir}/swapoff.${PN}
	ln -sf ${sbindir}/shutdown ${D}${sbindir}/reboot.${PN}
	ln -sf ${sbindir}/shutdown ${D}${sbindir}/halt.${PN}
	ln -sf ${sbindir}/shutdown ${D}${sbindir}/fastboot
	ln -sf ${sbindir}/shutdown ${D}${sbindir}/fasthalt
}

python populate_packages_prepend () {
	ulinxng_libdir = bb.data.expand('${libdir}', d)
	ulinxng_libdir_dbg = bb.data.expand('${libdir}/.debug', d)
	do_split_packages(d, ulinxng_libdir, '^lib(.*)\.so$', 'lib%s-dev', 'util-linux-ng %s development package', extra_depends='${PN}-dev', allow_links=True)
	do_split_packages(d, ulinxng_libdir, '^lib(.*)\.la$', 'lib%s-dev', 'util-linux-ng %s development package', extra_depends='${PN}-dev')
	do_split_packages(d, ulinxng_libdir, '^lib(.*)\.a$', 'lib%s-dev', 'util-linux-ng %s development package', extra_depends='${PN}-dev')
	do_split_packages(d, ulinxng_libdir, '^lib(.*)\.so\.*', 'lib%s', 'util-linux-ng %s library', extra_depends='', allow_links=True)
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
	update-alternatives --install ${bindir}/chfn chfn chfn.${PN} 100
	update-alternatives --install ${bindir}/newgrp newgrp newgrp.${PN} 100
	update-alternatives --install ${bindir}/chsh chsh chsh.${PN} 100
	update-alternatives --install ${base_bindir}/login login login.${PN} 100
	update-alternatives --install ${base_sbindir}/vipw vipw vipw.${PN} 100
	update-alternatives --install ${base_sbindir}/vigr vigr vigr.${PN} 100
	
	# There seems to be problem, atleast on nslu2, with these, until they are
	# fixed the busybox ones have higher priority
	update-alternatives --install ${base_sbindir}/hwclock hwclock hwclock.${PN} 10
	update-alternatives --install ${base_sbindir}/shutdown shutdown shutdown.${PN} 10
	update-alternatives --install ${base_sbindir}/reboot reboot reboot.${PN} 10
	update-alternatives --install ${base_sbindir}/halt halt halt.${PN} 10
}

pkg_prerm_${PN} () {
	test -x ${base_sbindir}/pivot_root.${PN} && \
	update-alternatives --remove pivot_root pivot_root.${PN}i

	for i in dmesg kill more halt hwclock mkswap reboot shutdown sln mkfs.minix fsck.minix hecdump last logger mesg renice wall vipw vigr chfn newgrp chsh login ; do
		update-alternatives --remove $i $i.${PN}
	done
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

