DESCRIPTION = "Freetype font rendering library"
SECTION = "libs"
LICENSE = "freetype"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/freetype/freetype-${PV}.tar.bz2 \
	   file://configure.patch;patch=1 \
           file://no-hardcode.patch;patch=1"
S = "${WORKDIR}/freetype-${PV}"

inherit autotools pkgconfig binconfig

DEFAULT_PREFERENCE = "-1"

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

do_compile_prepend() {
	${BUILD_CC} -o objs/apinames src/tools/apinames.c
}

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${bindir}"

SRC_URI[md5sum] = "5b331456e0357e90d57cab5943dbe560"
SRC_URI[sha256sum] = "1b1bb146b8d2fd04ea03106da5f8abfd83e44c04a060fd7a38d06d6a224390bd"
