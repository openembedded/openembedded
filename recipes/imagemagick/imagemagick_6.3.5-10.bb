DESCRIPTION = "ImageMagick is an image convertion tools"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "tiff jpeg libpng librsvg tiff zlib"
PR = "r9"

SRC_URI = "ftp://ftp.nluug.nl/pub/ImageMagick/ImageMagick-${PV}.tar.bz2 \
           file://PerlMagic_MakePatch;apply=yes \
           file://makefile-am.patch \
           file://binconfig-fixes.patch \
           file://fix_open_file.patch \
           file://openm4-autoconf-fix.patch"

IMVER = "6.3.5"

S = "${WORKDIR}/ImageMagick-${IMVER}"

inherit autotools binconfig pkgconfig

EXTRA_AUTORECONF += "--exclude=libtoolize"
EXTRA_OECONF = "--without-x --without-freetype --without-perl"
EXTRA_OECONF_openprotium = "--without-x --without-freetype --without-xml --without-perl"

FILES_${PN} += "${libdir}/ImageMagick-${IMVER}/modules-Q16/*/*.so \
                ${libdir}/ImageMagick-${IMVER}/modules-Q16/*/*.la \
                ${libdir}/ImageMagick-${IMVER}/config/ \
                ${datadir}/ImageMagick-${IMVER}"

FILES_${PN}-dev += "${libdir}/ImageMagick-${IMVER}/modules-Q16/*/*.a"

FILES_${PN}-dbg += "${libdir}/ImageMagick-${IMVER}/modules-Q16/*/.debug/*"

BBCLASSEXTEND = "native"

LEAD_SONAME = "libMagick.so.*"


SRC_URI[md5sum] = "1b31777138ed78ae0e95b8480cb7e2c2"
SRC_URI[sha256sum] = "a4d26fb438b15502cc4fb7842111d75d0bd4958c484b3d1bbe25dc60b4e63f84"
