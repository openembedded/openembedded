SECTION = "libs"
DESCRIPTION = "shared library for GIF images"
SRC_URI = "${SOURCEFORGE_MIRROR}/libungif/libungif-${PV}.tar.bz2"
LICENSE = "MIT"
PR = "r1"

PACKAGES += "${PN}-utils"

FILES_${PN} = "${libdir}"
FILES_${PN}-utils = "${bindir}"

inherit autotools

do_stage() {
	oe_libinstall -so -C lib/.libs libungif ${STAGING_LIBDIR}

	install -m 0644 lib/gif_lib.h ${STAGING_INCDIR}/

}
