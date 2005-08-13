DESCRIPTION = "Engage is the E17 icon dock"
DEPENDS = "esmart virtual/imlib2 edje virtual/ecore virtual/evas ewl e-wm"
LICENSE = "MIT"
SECTION = "e"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
PR = "r0"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=misc/engage"
S = "${WORKDIR}/engage"

inherit autotools pkgconfig binconfig

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc"

do_prepsources () {
  make clean distclean || true
}
addtask prepsources after do_fetch before do_unpack

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"

