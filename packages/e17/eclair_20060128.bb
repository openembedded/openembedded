DESCRIPTION = "Eclair is the E17 multi media player"
DEPENDS = "evas-x11 ecore-x11 embryo imlib2-x11 edje-native edje libxine-x11 emotion esmart-x11 libxml2 sqlite3 taglibc"
LICENSE = "MIT"
PR = "r1"

inherit e

SRC_URI = "${E_CVS};module=e17/apps/eclair;date=${PV}"
S = "${WORKDIR}/eclair"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"

