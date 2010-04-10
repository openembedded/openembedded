SECTION = "libs"
DESCRIPTION = "shared library for GIF images"
SRC_URI = "${SOURCEFORGE_MIRROR}/giflib/libungif-${PV}.tar.bz2"
LICENSE = "MIT"
PR = "r2"

PACKAGES += "${PN}-utils"

FILES_${PN} = "${libdir}"
FILES_${PN}-utils = "${bindir}"

inherit autotools

do_stage() {
	oe_libinstall -so -C lib/.libs libungif ${STAGING_LIBDIR}

	install -m 0644 lib/gif_lib.h ${STAGING_INCDIR}/

}

SRC_URI[md5sum] = "8c198831cc0495596c78134b8849e9ad"
SRC_URI[sha256sum] = "59e835a57e6df03e4d2253b2357253f3d13da9473ff465563a3b9833a744fc36"
