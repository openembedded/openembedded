DESCRIPTION = "A graphic library for file loading, saving, rendering, and \
manipulation."
HOMEPAGE = "http://www.enlightenment.org"
MAINTAINER = "Carsten Haitzler (Rasterman) <raster@rasterman.com>"
LICENSE = BSD
SECTION = "e/libs"
PRIORITY = "optional"
DEPENDS = "freetype libpng jpeg x11 xext"
PR = "r4"

do_prepsources () {
	make clean distclean || true
}
addtask prepsources after do_fetch before do_unpack

SRC_URI = "${SOURCEFORGE_MIRROR}/enlightenment/imlib2-1.2.0.tar.gz \
	   file://binconfig.patch;patch=1 \
	   file://x.patch;patch=1"

inherit autotools pkgconfig binconfig

EXTRA_OECONF = "--disable-mmx \
		--with-x \
		--x-includes=${STAGING_INCDIR} \
		--x-libraries=${STAGING_LIBDIR}"

do_stage () {
	oe_libinstall -C src/lib libImlib2 ${STAGING_LIBDIR}/
	install -m 0644 ${S}/src/lib/Imlib2.h ${STAGING_INCDIR}/
}

PACKAGES += "${PN}-bin"
FILES_${PN} = "${libdir}/lib*.so.* ${libdir}/imlib2"
FILES_${PN}-dev += "${bindir}/imlib2-config"
FILES_${PN}-bin = "${bindir}"
