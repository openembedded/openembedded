DESCRIPTION = "ImageMagick is an image convertion tools"
SECTION = "console/utils"
LICENSE = "GPL"
# FIXME: There is much more checked libraries. All should be added or explicitly disabled to get consistent results.
DEPENDS = "bzip2 jpeg libpng librsvg tiff zlib"

PR = "r4"

SRC_URI = "ftp://ftp.nluug.nl/pub/ImageMagick/ImageMagick-${PV}.tar.bz2 \
           file://PerlMagic_MakePatch;patch=1 \
          "

IMVER = "6.4.4"

S = "${WORKDIR}/ImageMagick-${IMVER}"

inherit autotools_stage binconfig pkgconfig

EXTRA_AUTORECONF += "--exclude=libtoolize"
EXTRA_OECONF = "--program-prefix= --without-x --without-freetype --without-perl --disable-openmp"

FILES_${PN} += "${libdir}/ImageMagick-${IMVER}/modules-Q16/*/*.so \
                ${libdir}/ImageMagick-${IMVER}/modules-Q16/*/*.la \
                ${libdir}/ImageMagick-${IMVER}/config/ \
                ${datadir}/ImageMagick-${IMVER}"

FILES_${PN}-dev += "${libdir}/ImageMagick-${IMVER}/modules-Q16/*/*.a"

FILES_${PN}-dbg += "${libdir}/ImageMagick-${IMVER}/modules-Q16/*/.debug/*"

BBCLASSEXTEND = "native"

LEAD_SONAME = "libMagickCore.so.*"


SRC_URI[md5sum] = "882ff241f6ad39655541d5055596f93b"
SRC_URI[sha256sum] = "5a5b2779707bfd9816cf17d8f53d242c05005092da192a898ac10961b3b19dda"
