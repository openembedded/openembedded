# syslinux OE build file
# Copyright (C) 2009, 2011, O.S. Systems Software Ltda.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "A multi-purpose linux bootloader"
HOMEPAGE = "http://syslinux.zytor.com/"
LICENSE = "GPL"
DEPENDS = "nasm-native"
RRECOMMENDS_${PN} = "mtools"
PR = "r3"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/utils/boot/syslinux/syslinux-${PV}.tar.bz2 "

EXTRA_OEMAKE = " \
	BINDIR=${bindir} SBINDIR=${base_sbindir} LIBDIR=${libdir} \
	DATADIR=${datadir} MANDIR=${mandir} INCDIR=${includedir} \
"

do_configure() {
	# drop win32 targets or build fails
	sed -e 's,win32/\S*,,g' -i Makefile

	# clean installer executables included in source tarball
	oe_runmake clean
}

do_compile() {
	# Rebuild only the installer; keep precompiled bootloaders
	# as per author's request (doc/distrib.txt)
	oe_runmake CC="${CC}" LDFLAGS="${LDFLAGS}" installer
}

do_install() {
	oe_runmake install INSTALLROOT="${D}"
}

PACKAGES =+ "${PN}-extlinux ${PN}-mbr ${PN}-chain ${PN}-pxelinux ${PN}-isolinux"
FILES_${PN} = "${bindir}/syslinux"
FILES_${PN}-extlinux = "${base_sbindir}/extlinux"
FILES_${PN}-mbr = "${datadir}/${PN}/mbr.bin"
FILES_${PN}-chain = "${datadir}/${PN}/chain.c32"
FILES_${PN}-isolinux = "${datadir}/${PN}/isolinux.bin"
FILES_${PN}-pxelinux = "${datadir}/${PN}/pxelinux.0"
FILES_${PN}-dev += "${datadir}/${PN}/com32"

SRC_URI[md5sum] = "c9f4e73e385c86b3a8faf9b615a04836"
SRC_URI[sha256sum] = "1dbbf8cfd10fc07187fa8bfede23639fc95314976730f3474cb349e8bf6c6f61"
