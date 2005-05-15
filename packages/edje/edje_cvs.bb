DESCRIPTION = "Edje is a graphical layout and animation library for animated \
resizable, compressed and scalable themes."
HOMEPAGE = "http://www.enlightenment.org"
MAINTAINER = "Carsten Haitzler (Rasterman) <raster@rasterman.com>"
SECTION = "e/libs"
PRIORITY = "optional"
DEPENDS = "evas ecore embryo eet imlib2"
PV = "0.5.0"
PR = "1"

do_prepsources () {
  make clean distclean || true
}
addtask prepsources after do_fetch before do_unpack
  
SRC_URI = "cvs://anonymous@cvs.sourceforge.net:/cvsroot/enlightenment;module=edje"

S = "${WORKDIR}/edje"
  
inherit autotools pkgconfig binconfig

export EET_CONFIG = "${STAGING_BINDIR}/eet-config"
export EVAS_CONFIG = "${STAGING_BINDIR}/evas-config"
export ECORE_CONFIG = "${STAGING_BINDIR}/ecore-config"
export EMBRYO_CONFIG = "${STAGING_BINDIR}/embryo-config"
export IMLIB2_CONFIG = "${STAGING_BINDIR}/imlib2-config"

LEAD_SONAME = "libedje.so"

do_stage () {
  oe_libinstall -C src/lib libedje ${STAGING_LIBDIR}/
  install -m 0644 ${S}/src/lib/Edje.h ${STAGING_INCDIR}/
}

PACKAGES += "edje-tools edje-compiler"

FILES_${PN} = "${libdir}/libedje*.so*"
FILES_${PN}-dev += "${bindir}/edje-config ${libdir}/pkgconfig"
FILES_${PN}-compiler = "${bindir}/edje_cc ${datadir}/edje/include"
FILES_${PN}-tools = "${bindir}/edje ${bindir}/edje_ls ${datadir}/edje/data/test"

