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
