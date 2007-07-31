DESCRIPTION = "Edje_Viewer is just that."
DEPENDS = "etk"
LICENSE = "MIT"
PV = "0.0.0+cvs${SRCDATE}"
PR = "r0"

inherit e

SRC_URI = "${E_CVS};module=e17/apps/edje_viewer"
S = "${WORKDIR}/edje_viewer"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"
