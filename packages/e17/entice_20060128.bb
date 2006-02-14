DESCRIPTION = "Entice is the E17 picture viewer"
SECTION = "e/apps"
# can also depend on GIMP for editing
DEPENDS = "edb evas-x11 ecore-x11 edje epsilon esmart-x11"
LICENSE = "MIT"
HOMEPAGE = "http://www.enlightenment.org"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
PR = "r1"

SRC_URI = "cvs://anonymous@thinktux.net/root;module=e17/apps/entice;date=${PV}"
S = "${WORKDIR}/entice"

inherit autotools

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"

