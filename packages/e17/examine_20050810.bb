DESCRIPTION = "examine, the program configurator"
DEPENDS = "virtual/ecore ewl"
LICENSE = "MIT"
SECTION = "e"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
PR = "r0"
CVSDATE = "${PV}"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/apps/examine"
S = "${WORKDIR}/examine"

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
