DESCRIPTION = "Util-linux is a suite of essential utilities for any Linux system."
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "zlib ncurses"

inherit autotools

SRC_URI = "ftp://ftp.kernel.org/pub/linux/utils/util-linux/util-linux-${PV}.tar.bz2 \
           file://gcc34.patch;patch=1 \
           file://MCONFIG \
           file://make_include \
           file://swapargs.h \
           file://defines.h"

PACKAGES_prepend = "util-linux-fdisk util-linux-cfdisk util-linux-sfdisk util-linux-readprofile "

FILES_util-linux-fdisk = "/sbin/fdisk.${PN}"
FILES_util-linux-cfdisk = "/sbin/cfdisk"
FILES_util-linux-sfdisk = "/sbin/sfdisk"
FILES_util-linux-readprofile = "/usr/sbin/readprofile"

RRECOMMENDS_${PN} = "util-linux-fdisk util-linux-cfdisk util-linux-sfdisk util-linux-readprofile"

do_compile () {
	set -e
	install ${WORKDIR}/MCONFIG ${S}/MCONFIG
	install ${WORKDIR}/make_include ${S}/make_include
	install ${WORKDIR}/swapargs.h ${S}/mount/swapargs.h
	install ${WORKDIR}/defines.h ${S}/defines.h
	oe_runmake ARCH=${TARGET_ARCH} CPU= CPUOPT= \
		'OPT=${CFLAGS}' 'CC=${CC}' 'LD=${LD}' \
		'LDFLAGS=${LDFLAGS}'
}

do_install () {
	# with ccache the timestamps on compiled files may
	# end up earlier than on their inputs, this allows
	# for the resultant compilation in the install step.
	oe_runmake ARCH=${TARGET_ARCH} CPU= CPUOPT= \
		'OPT=${CFLAGS}' 'CC=${CC}' 'LD=${LD}' \
		'LDFLAGS=${LDFLAGS}' 'DESTDIR=${D}' install

	mv ${D}${base_bindir}/dmesg ${D}${base_bindir}/dmesg.${PN}
	mv ${D}${base_bindir}/kill ${D}${base_bindir}/kill.${PN}
	mv ${D}${base_bindir}/more ${D}${base_bindir}/more.${PN}
	mv ${D}${base_sbindir}/halt ${D}${base_sbindir}/halt.${PN}
	mv ${D}${base_sbindir}/hwclock ${D}${base_sbindir}/hwclock.${PN}
	mv ${D}${base_sbindir}/losetup ${D}${base_sbindir}/losetup.${PN}
	mv ${D}${base_sbindir}/mkswap ${D}${base_sbindir}/mkswap.${PN}
	mv ${D}${base_sbindir}/pivot_root ${D}${base_sbindir}/pivot_root.${PN}
	mv ${D}${base_sbindir}/reboot ${D}${base_sbindir}/reboot.${PN}
	mv ${D}${base_sbindir}/shutdown ${D}${base_sbindir}/shutdown.${PN}
	mv ${D}${base_sbindir}/sln ${D}${base_sbindir}/sln.${PN}
	mv ${D}${base_sbindir}/swapoff ${D}${base_sbindir}/swapoff.${PN}
	mv ${D}${base_sbindir}/swapon ${D}${base_sbindir}/swapon.${PN}
	mv ${D}${bindir}/hexdump ${D}${bindir}/hexdump.${PN}
	mv ${D}${bindir}/last ${D}${bindir}/last.${PN}
	mv ${D}${bindir}/logger ${D}${bindir}/logger.${PN}
	mv ${D}${bindir}/mesg ${D}${bindir}/mesg.${PN}
	mv ${D}${bindir}/renice ${D}${bindir}/renice.${PN}
	mv ${D}${bindir}/wall ${D}${bindir}/wall.${PN}

	mv ${D}${base_sbindir}/fdisk ${D}${base_sbindir}/fdisk.${PN}
}

pkg_postinst_${PN} () {
	update-alternatives --install ${base_bindir}/dmesg dmesg dmesg.${PN} 100
	update-alternatives --install ${base_bindir}/kill kill kill.${PN} 100
	update-alternatives --install ${base_bindir}/more more more.${PN} 100
	update-alternatives --install ${base_sbindir}/hwclock hwclock hwclock.${PN} 100
	update-alternatives --install ${base_sbindir}/losetup losetup losetup.${PN} 100
	update-alternatives --install ${base_sbindir}/mkswap mkswap mkswap.${PN} 100
	update-alternatives --install ${base_sbindir}/pivot_root pivot_root pivot_root.${PN} 100
	update-alternatives --install ${base_sbindir}/sln sln sln.${PN} 100
	update-alternatives --install ${base_sbindir}/swapoff swapoff swapoff.${PN} 100
	update-alternatives --install ${base_sbindir}/swapon swapon swapon.${PN} 100
	update-alternatives --install ${bindir}/hexdump hexdump hexdump.${PN} 100
	update-alternatives --install ${bindir}/last last last.${PN} 100
	update-alternatives --install ${bindir}/logger logger logger.${PN} 100
	update-alternatives --install ${bindir}/mesg mesg mesg.${PN} 100
	update-alternatives --install ${bindir}/renice renice renice.${PN} 100
	update-alternatives --install ${bindir}/wall wall wall.${PN} 100
	
	# There seems to be problem, atleast on nslu2, with these, untill they are
	# fixed the busybox ones have higher priority
	update-alternatives --install ${base_sbindir}/shutdown shutdown shutdown.${PN} 10
	update-alternatives --install ${base_sbindir}/reboot reboot reboot.${PN} 10
	update-alternatives --install ${base_sbindir}/halt halt halt.${PN} 10
}

pkg_prerm_${PN} () {
	update-alternatives --remove dmesg dmesg.${PN}
	update-alternatives --remove kill kill.${PN}
	update-alternatives --remove more more.${PN}
	update-alternatives --remove halt halt.${PN}
	update-alternatives --remove hwclock hwclock.${PN}
	update-alternatives --remove losetup losetup.${PN}
	update-alternatives --remove mkswap mkswap.${PN}
	update-alternatives --remove pivot_root pivot_root.${PN}
	update-alternatives --remove reboot reboot.${PN}
	update-alternatives --remove shutdown shutdown.${PN}
	update-alternatives --remove sln sln.${PN}
	update-alternatives --remove swapoff swapoff.${PN}
	update-alternatives --remove swapon swapon.${PN}
	update-alternatives --remove hexdump hexdump.${PN}
	update-alternatives --remove last last.${PN}
	update-alternatives --remove logger logger.${PN}
	update-alternatives --remove mesg mesg.${PN}
	update-alternatives --remove renice renice.${PN}
	update-alternatives --remove wall wall.${PN}
}

pkg_postinst_util-linux-fdisk () {
	update-alternatives --install ${base_sbindir}/fdisk fdisk fdisk.${PN} 100
}

pkg_prerm_util-linux-fdisk () {
	update-alternatives --remove fdisk fdisk.${PN}
}

