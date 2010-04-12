DESCRIPTION = "Freetype font rendering library"
SECTION = "libs"
LICENSE = "freetype"
PR = "r2"

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

SRC_URI[md5sum] = "5b2f827082c544392a7701f7423f0781"
SRC_URI[sha256sum] = "0e8eb40392752b306d3a3de21f9fa479d53c17bd774b8051771cb258e162e006"
