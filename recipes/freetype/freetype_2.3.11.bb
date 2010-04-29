DESCRIPTION = "Freetype font rendering library"
SECTION = "libs"
LICENSE = "freetype"
PR = "r0"

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

SRC_URI[md5sum] = "519c7cbf5cbd72ffa822c66844d3114c"
SRC_URI[sha256sum] = "8a033b1e6018a1e9ea381b09b2347b02c6686bdf7e4ee86a6714b6b90f1e2ec9"
