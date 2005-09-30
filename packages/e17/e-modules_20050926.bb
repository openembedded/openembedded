DESCRIPTION = "Enlightenment Window Manager Extra Modules"
DEPENDS = "ecore-x11 evas-x11 esmart-x11 edje eet e"
LICENSE = "MIT"
SECTION = "e/apps"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
CVSDATE = "${PV}"
PR = "r1"

inherit autotools

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/apps/e_modules"
S = "${WORKDIR}/e_modules"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir}"
