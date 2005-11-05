# bootsplash OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="Bootsplash shows pretty pictures during boot"
HOMEPAGE="http://www.bootsplash.org"
SECTION = "media-gfx"
LICENSE = "GPL"
SRC_URI="ftp://ftp.openbios.org/pub/bootsplash/rpm-sources/bootsplash/bootsplash-${PV}.tar.bz2"

DEPENDS="freetype"

do_compile() {
	oe_runmake -C Utilities 
}

do_install() {
	install -d ${D}${bindir}/
	install -m 0755 ${S}/Utilities/fbtruetype ${D}${bindir}
	install -m 0755 ${S}/Utilities/splash ${D}${bindir}
}
