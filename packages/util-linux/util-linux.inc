DESCRIPTION = "Util-linux is a suite of essential utilities for any Linux system."
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "zlib ncurses"
PR="r1"

PACKAGES_prepend = "util-linux-fdisk util-linux-cfdisk util-linux-sfdisk util-linux-readprofile "

FILES_util-linux-fdisk = "/sbin/fdisk"
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
	oe_runmake 'DESTDIR=${D}' install
}
