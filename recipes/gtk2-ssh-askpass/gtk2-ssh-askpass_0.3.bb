# gtk2-ssh-askpass OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="GTK2 ssh askpass utility"
HOMEPAGE="http://www.cgabriel.org/sw/gtk2-ssh-askpass/"
LICENSE = "GPL"
SECTION = "network/misc"

SRC_URI="http://src.gentoo.pl/distfiles/gtk2-ssh-askpass-${PV}.tar.gz \
	file://makefile.patch;patch=1"

DEPENDS="gtk+"

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${libexecdir}
	cp ${S}/gtk2-ssh-askpass ${D}${bindir}
	ln -s ${bindir}/gtk2-ssh-askpass ${D}${libexecdir}/ssh-askpass
}

SRC_URI[md5sum] = "14ca8c653ad19699b7299198d7a94e0a"
SRC_URI[sha256sum] = "5b0a2b2ea2cbe26d7738a360ba5aad57d7d03297a662cf209a032c0b9725d33c"
