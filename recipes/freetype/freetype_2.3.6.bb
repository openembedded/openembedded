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

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${bindir}"

SRC_URI[md5sum] = "fb182d508017cb608e9df8c7dca648dc"
SRC_URI[sha256sum] = "d5a698c30376d14c1ce6540ed6d5627796421e6e97576620ea4562411a110e77"
