LICENSE = "GPL"
SECTION = "console/utils"
DEPENDS = "tiff"
DESCRIPTION = "ImageMagick is an image convertion tools"

SRC_URI = "ftp://ftp.nluug.nl/pub/ImageMagick/ImageMagick-${PV}-2.tar.bz2 \
	   file://PerlMagic_MakePatch;patch=1"

S = "${WORKDIR}/ImageMagick-${PV}"

inherit autotools

EXTRA_OECONF="-without-x "

LEAD_SONAME="libMagick.so.*"

FILES_${PN} += "${libdir}/ImageMagick-${PV}/modules-Q16/*/*.so \
		${libdir}/ImageMagick-${PV}/config/ \
		${datadir}/ImageMagick-${PV}"

FILES_${PN}-dbg += "${libdir}/ImageMagick-${PV}/modules-Q16/*/.debug/*"
