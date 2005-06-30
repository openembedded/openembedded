DESCRIPTION = "EET is a tiny library designed to write an \
arbitary set of chunks of data to a file and optionally compress \
each chunk (very much like a zip file) and allow fast \
random-access reading of the file later on."
HOMEPAGE = "http://www.enlightenment.org"
MAINTAINER = "Carsten Haitzler (Rasterman) <raster@rasterman.com>"
SECTION = "e/libs"
PRIORITY = "optional"
include eet_${PV}.bb
inherit native
DEPENDS = "zlib-native jpeg-native"
LICENSE = "BSD"

do_stage () {
  install -m 0755 src/bin/.libs/eet ${STAGING_BINDIR}
  oe_libinstall -C src/lib libeet ${STAGING_LIBDIR}/
  install -m 0644 ${S}/src/lib/Eet.h ${STAGING_INCDIR}/
}
