DESCRIPTION = "Eclair is the E17 multi media player"
SECTION = "e/apps"
DEPENDS = "evas-x11 ecore-x11 embryo imlib2-x11 edje-native edje libxine-x11 emotion esmart-x11 libxml2 sqlite3 taglibc"
LICENSE = "MIT"
HOMEPAGE = "http://www.enlightenment.org"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
PR = "r1"

SRC_URI = "cvs://anonymous@thinktux.net/root;module=e17/apps/eclair;date=${PV}"
S = "${WORKDIR}/eclair"

inherit autotools

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"

