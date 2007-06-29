DESCRIPTION = "Entice is the E17 picture viewer"
# can also depend on GIMP for editing
LICENSE = "MIT"
DEPENDS = "edb evas ecore edje epsilon esmart"
PV = "0.0.0+cvs${SRCDATE}"
PR = "r0"

inherit e

SRC_URI = "${E_CVS};module=e17/apps/entice"
S = "${WORKDIR}/entice"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"
