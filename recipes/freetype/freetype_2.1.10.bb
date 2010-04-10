DESCRIPTION = "Freetype font rendering library"
HOMEPAGE = "http://www.freetype.org"
SECTION = "libs"
LICENSE = "freetype"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/freetype/freetype-${PV}.tar.bz2 \
	   file://configure.patch;patch=1 \
	   file://no-hardcode.patch;patch=1"
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

SRC_URI[md5sum] = "a4012e7d1f6400df44a16743b11b8423"
SRC_URI[sha256sum] = "fed2ed148d7d105b95493c5e95561c8b05ee7909e00f828f036d8ed1be6a5e53"
