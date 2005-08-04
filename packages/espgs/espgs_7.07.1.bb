DESCRIPTION = "ESP Ghostscript is an up-to-date GNU Ghostscript distribution \
including bug fixes, new drivers, and additional support for CUPS."
HOMEPAGE = "http://espgs.sf.net"
SECTION = "libs"
DEPENDS = "jpeg zlib libpng"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/espgs/espgs-${PV}-source.tar.bz2"
S = "${WORKDIR}/espgs-${PV}"

PARALLEL_MAKE = ""

inherit autotools

EXTRA_OECONF = "--with-drivers= \
		--without-ijs \
		--without-gimp-print \
		--without-omni \
		--without-x \
		--disable-cups"

do_compile() {
	oe_runmake CCAUX="${BUILD_CC}"
}

do_install () {
	oe_runmake 'prefix=${D}${prefix}' \
		   'bindir=${D}${bindir}' \
		   'datadir=${D}${datadir}' \
		   'mandir=${D}${mandir}' install
}
