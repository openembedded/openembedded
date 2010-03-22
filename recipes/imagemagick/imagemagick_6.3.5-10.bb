DESCRIPTION = "ImageMagick is an image convertion tools"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "tiff jpeg libpng librsvg tiff zlib"
PR = "r7"

SRC_URI = "ftp://ftp.nluug.nl/pub/ImageMagick/ImageMagick-${PV}.tar.bz2 \
           file://PerlMagic_MakePatch;patch=1 \
           file://makefile-am.patch;patch=1 \
           file://binconfig-fixes.patch;patch=1 \
	   file://fix_open_file.patch;patch=1 "

IMVER = "6.3.5"

S = "${WORKDIR}/ImageMagick-${IMVER}"

inherit autotools binconfig pkgconfig

EXTRA_AUTORECONF += "--exclude=libtoolize"
EXTRA_OECONF = "--without-x --without-freetype --without-perl"
EXTRA_OECONF_openprotium = "--without-x --without-freetype --without-xml --without-perl"

do_stage() {
	autotools_stage_all
}

FILES_${PN} += "${libdir}/ImageMagick-${IMVER}/modules-Q16/*/*.so \
                ${libdir}/ImageMagick-${IMVER}/modules-Q16/*/*.la \
                ${libdir}/ImageMagick-${IMVER}/config/ \
                ${datadir}/ImageMagick-${IMVER}"

FILES_${PN}-dev += "${libdir}/ImageMagick-${IMVER}/modules-Q16/*/*.a"

FILES_${PN}-dbg += "${libdir}/ImageMagick-${IMVER}/modules-Q16/*/.debug/*"

LEAD_SONAME = "libMagick.so.*"

