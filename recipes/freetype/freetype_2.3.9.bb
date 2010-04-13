DESCRIPTION = "Freetype font rendering library"
SECTION = "libs"
LICENSE = "freetype"
PR = "r1"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/freetype/freetype-${PV}.tar.bz2 \
  file://no-hardcode.patch;patch=1 \
  file://fix-configure.patch;patch=1 \
  file://libtool-tag.patch;patch=1 \
"
S = "${WORKDIR}/freetype-${PV}"

inherit autotools pkgconfig binconfig

LIBTOOL = "${HOST_SYS}-libtool"
EXTRA_OEMAKE = "'LIBTOOL=${LIBTOOL}'"
EXTRA_OECONF = "--without-zlib"

do_configure() {
	cd builds/unix
	libtoolize --force --copy
	gnu-configize --force
	aclocal -I .
	autoconf
	cd ${S}
	oe_runconf
}

do_compile_prepend() {
	${BUILD_CC} -o objs/apinames src/tools/apinames.c
}

BBCLASSEXTEND = "native"

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${bindir}"

SRC_URI[md5sum] = "d76233108aca9c9606cdbd341562ad9a"
SRC_URI[sha256sum] = "51a033bce9904d73e0821e8e2bba24bd319619d7d1b2e9eeccac611580242ab6"
