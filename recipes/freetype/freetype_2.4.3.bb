DESCRIPTION = "Freetype font rendering library"
SECTION = "libs"
LICENSE = "freetype GPLv2"
PR = "r1"
DEPENDS = "zlib"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/freetype/freetype-${PV}.tar.bz2 \
  file://no-hardcode.patch \
  file://libtool-tag.patch \
"
S = "${WORKDIR}/freetype-${PV}"

SRC_URI[md5sum] = "75ac7082bde7b3805dc5d6bc806fa045"
SRC_URI[sha256sum] = "b4e626db62fd1b4549ff5d57f5eca3a41631fd6066adf8a31c11879b51249afc"

inherit autotools pkgconfig binconfig

LIBTOOL = "${S}/builds/unix/${HOST_SYS}-libtool"
EXTRA_OEMAKE = "'LIBTOOL=${LIBTOOL}'"

LDFLAGS_append = " -Wl,-rpath-link -Wl,${STAGING_DIR_TARGET}${libdir}"

do_configure() {
	cd builds/unix
	gnu-configize --force
	aclocal -I .
	libtoolize --force --copy
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
