DESCRIPTION = "A graphic library for file loading, saving, rendering, and \
manipulation."
HOMEPAGE = "http://www.enlightenment.org"
MAINTAINER = "Carsten Haitzler (Rasterman) <raster@rasterman.com>"
LICENSE = "BSD"
SECTION = "e/libs"
PRIORITY = "optional"
include imlib2.bb
inherit native
DEPENDS = "freetype-native libpng-native jpeg-native"

do_stage () {
  oe_libinstall -C src/lib libImlib2 ${STAGING_LIBDIR}/
  install -m 0644 ${S}/src/lib/Imlib2.h ${STAGING_INCDIR}/
}
