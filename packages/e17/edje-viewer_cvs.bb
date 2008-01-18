DESCRIPTION = "Edje_Viewer is just that."
DEPENDS = "etk"
LICENSE = "MIT BSD"
PV = "0.0.0+cvs${SRCDATE}"
PR = "r3"

inherit e

SRC_URI = "${E_CVS};module=e17/apps/edje_viewer \
           file://no-minimal-size.patch;patch=1"
S = "${WORKDIR}/edje_viewer"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"
