DESCRIPTION = "Engage is the E17 icon dock"
DEPENDS = "evas-x11 ecore-x11 esmart-x11 imlib2-x11 edje ewl e"
LICENSE = "MIT"
PR = "r2"

inherit e

SRC_URI = "${E_CVS};module=misc/engage;date=${PV} \
           file://no-local-includes.patch;patch=1"
S = "${WORKDIR}/engage"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"

