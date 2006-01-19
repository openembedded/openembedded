DESCRIPTION = "An Iconbar for the Enlightenment Window Manager"
DEPENDS = "edb eet evas-x11 ecore-x11 edje esmart-x11 imlib2-x11"
LICENSE = "MIT"
SECTION = "e/apps"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
PR = "r1"

SRC_URI = "cvs://anonymous@thinktux.net/root;module=e17/apps/iconbar;date=${PV}"
S = "${WORKDIR}/iconbar"

inherit autotools

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"
