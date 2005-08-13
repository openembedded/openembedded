DESCRIPTION = "engage, e17 icon dock"
DEPENDS = "esmart virtual/imlib2 edje virtual/ecore virtual/evas ewl e-wm"
LICENSE = "MIT"
SECTION = "e"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
PR = "r0"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=misc/engage"
S = "${WORKDIR}/engage"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc"

do_prepsources () {
  make clean distclean || true
}
addtask prepsources after do_fetch before do_unpack

export EET_CONFIG = "${STAGING_BINDIR}/eet-config"
export EVAS_CONFIG = "${STAGING_BINDIR}/evas-config"
export ECORE_CONFIG = "${STAGING_BINDIR}/ecore-config"
export EMBRYO_CONFIG = "${STAGING_BINDIR}/embryo-config"
export EDJE_CONFIG = "${STAGING_BINDIR}/edje-config"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} /etc/* /usr/sbin/*"

inherit autotools pkgconfig binconfig
