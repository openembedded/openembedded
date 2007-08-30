LICENSE = "GPL"
SECTION = "console/utils"
DEPENDS = "tiff"
DESCRIPTION = "ImageMagick is an image convertion tools"

SRC_URI = "ftp://ftp.nluug.nl/pub/ImageMagick/ImageMagick-${PV}-2.tar.bz2 \
	   file://PerlMagic_MakePatch;patch=1"

S = "${WORKDIR}/ImageMagick-${PV}"
PR="r1"

inherit autotools binconfig

EXTRA_OECONF="--without-x"
EXTRA_OECONF_openprotium="--without-x --without-xml --without-perl"

LEAD_SONAME="libMagick.so.*"

FILES_${PN} += "${libdir}/ImageMagick-${PV}/modules-Q16/*/*.so \
        ${libdir}/ImageMagick-${PV}/modules-Q16/*/*.la \
		${libdir}/ImageMagick-${PV}/config/ \
		${datadir}/ImageMagick-${PV}"

FILES_${PN}-dbg += "${libdir}/ImageMagick-${PV}/modules-Q16/*/.debug/*"

do_stage() {
    oe_libinstall -so -a libMagick ${STAGING_LIBDIR}
    oe_libinstall -so -a libWand ${STAGING_LIBDIR}
    install -d ${STAGING_INCDIR}/wand/
    install -d ${STAGING_INCDIR}/magick/
    install -m 0644 wand/*.h ${STAGING_INCDIR}/wand/
    install -m 0644 magick/*.h ${STAGING_INCDIR}/magick/
}
