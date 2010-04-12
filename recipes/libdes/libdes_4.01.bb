DESCRIPTION = "A DES encryption library"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "libdes"
SRC_URI = "http://www.agentpp.com/libdes-l-${PV}.tar.gz \
           file://cross-compile.patch;patch=1"
S = "${WORKDIR}/libdes"

do_compile() {
	oe_runmake libdes.a
}

do_stage() {
	oe_libinstall -a libdes ${STAGING_LIBDIR}
	install -m 0644 ${S}/des.h ${STAGING_INCDIR}/
}

SRC_URI[md5sum] = "6c5b6fff276c3a1171ceb41c6d4b6e34"
SRC_URI[sha256sum] = "76866075a54aa04f4f18f2cf09cf19c84dee4ed22c45b741dc4067f5e224430d"
