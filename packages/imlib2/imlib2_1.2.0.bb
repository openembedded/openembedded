DESCRIPTION = "A graphic library for file loading, saving, rendering, and \
manipulation."
HOMEPAGE = "http://www.enlightenment.org"
MAINTAINER = "Carsten Haitzler (Rasterman) <raster@rasterman.com>"
LICENSE = BSD
SECTION = "e/libs"
PRIORITY = "optional"
DEPENDS = "freetype libpng jpeg"
PV = "1.2.0"
PR = "1"

do_prepsources () {
  make clean distclean || true
}
addtask prepsources after do_fetch before do_unpack

#SRC_URI = "file://./"
SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/libs/imlib2"
S = "${WORKDIR}/imlib2"

inherit autotools pkgconfig binconfig

export FREETYPE_CONFIG = "${STAGING_BINDIR}/freetype-config"
export EET_CONFIG = "${STAGING_BINDIR}/eet-config"

EXTRA_OECONF = "--disable-mmx \
                --disable-x11"

do_stage () {
  oe_libinstall -C src/lib libImlib2 ${STAGING_LIBDIR}/
  install -m 0644 ${S}/src/lib/Imlib2.h ${STAGING_INCDIR}/
}

FILES_${PN} = "${libdir}/libImlib2*.so*"
FILES_${PN} = "${libdir}/imlib2"
FILES_${PN}-dev += "${bindir} ${libdir}/pkgconfig"
 
