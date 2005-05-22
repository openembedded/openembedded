DESCRIPTION = "A graphic library for file loading, saving, rendering, and manipulation."
HOMEPAGE = "http://www.enlightenment.org"
LICENSE = "BSD"
SECTION = "e/libs"
PRIORITY = "optional"
PROVIDES = "virtual/imlib2"
DEPENDS = "freetype libpng jpeg"

do_prepsources () {
	make clean distclean || true
}
addtask prepsources after do_fetch before do_unpack

SRC_URI = "http://enlightenment.freedesktop.org/files/imlib2-${PV}.tar.gz"
S = "${WORKDIR}/imlib2-${PV}"

inherit autotools pkgconfig binconfig

do_stage () {
	oe_libinstall -C src/lib libImlib2 ${STAGING_LIBDIR}/
	install -m 0644 ${S}/src/lib/Imlib2.h ${STAGING_INCDIR}/
}

PACKAGES += "${PN}-bin"
FILES_${PN} = "${libdir}/lib*.so.* ${libdir}/imlib2"
FILES_${PN}-dev += "${bindir}/imlib2-config"
FILES_${PN}-bin = "${bindir}"
