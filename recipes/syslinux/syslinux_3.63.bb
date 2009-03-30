# syslinux OE build file
# Copyright (C) 2009, O.S. Systems Software Ltda.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="A multi-purpose linux bootloader"
HOMEPAGE="http://syslinux.zytor.com/"
LICENSE="GPL"
DEPENDS="nasm-native"
RDEPENDS="mtools"
PR="r2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/utils/boot/syslinux/syslinux-${PV}.tar.bz2 "

S="${WORKDIR}/syslinux-${PV}"

inherit autotools

do_configure_prepend() {
	# drop win32 targets or build fails
	sed -i 's,win32/\S*,,g' -i Makefile
}

do_compile() {
	oe_runmake CC="${CC}"
}

do_install() {
	oe_runmake install INSTALLROOT="${D}"

	# we don't use com32, drop it
	rm -r "${D}/${libdir}/syslinux/com32"
}
