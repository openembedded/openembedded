DESCRIPTION = "examine, the program configurator"
DEPENDS = "virtual/ecore ewl"
LICENSE = "MIT"
SECTION = "e/apps"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
PR = "r0"
CVSDATE = "${PV}"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/apps/examine"
S = "${WORKDIR}/examine"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc"

inherit autotools pkgconfig binconfig

do_prepsources () {
  make clean distclean || true
}
addtask prepsources after do_fetch before do_unpack

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"
