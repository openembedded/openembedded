DESCRIPTION = "Freetype font rendering library"
SECTION = "libs"
LICENSE = "freetype"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/freetype/freetype-${PV}.tar.bz2 \
           file://fix-x86_64-build.patch;patch=1"
#           file://no-hardcode.patch;patch=1"
#	   file://configure.patch;patch=1 \
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

SRC_URI[md5sum] = "11e1186ca5520c5a284fa0a03f652035"
SRC_URI[sha256sum] = "be38eecd22880089223dc7e49ac79ce4fdfd1cb7ea09b3a4ef9bd1966f0d6155"
