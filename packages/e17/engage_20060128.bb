DESCRIPTION = "Engage is the E17 icon dock"
DEPENDS = "evas-x11 ecore-x11 esmart-x11 imlib2-x11 edje ewl e"
LICENSE = "MIT"
SECTION = "e/apps"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
PR = "r2"

SRC_URI = "cvs://anonymous@thinktux.net/root;module=misc/engage;date=${PV} \
           file://no-local-includes.patch;patch=1"
S = "${WORKDIR}/engage"

inherit autotools pkgconfig binconfig

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc"

do_prepsources () {
  make clean distclean || true
}
addtask prepsources after do_fetch before do_unpack

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"

