DESCRIPTION = "Freetype font rendering library"
SECTION = "libs"
LICENSE = "freetype"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/freetype/freetype-${PV}.tar.bz2 \
	   file://configure.patch;patch=1"
S = "${WORKDIR}/freetype-${PV}"

inherit autotools pkgconfig binconfig

LIBTOOL = "${S}/builds/unix/${HOST_SYS}-libtool"
EXTRA_OEMAKE = "'LIBTOOL=${LIBTOOL}'"
EXTRA_OECONF = "--without-zlib"

do_configure() {
	cd builds/unix
	gnu-configize
	aclocal -I .
	autoconf
	cd ${S}
	oe_runconf
}

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${bindir}"
