DESCRIPTION = "Edje-Editor is just that."
LICENSE = "MIT"
DEPENDS = "etk"
PV = "0.0.0+cvs${SRCDATE}"
PR = "r0"

inherit e

SRC_URI = "${E_CVS};module=e17/proto/edje_editor"
S = "${WORKDIR}/edje_editor"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"
