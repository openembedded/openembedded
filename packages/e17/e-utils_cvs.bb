DESCRIPTION = "Enlightenment Window Manager Utilities"
DEPENDS = "eet evas ecore edje esmart ewl engrave"
LICENSE = "MIT"
PV = "0.0.0+cvs${SRCDATE}"
PR = "r0"

inherit e

SRC_URI = "${E_CVS};module=e17/apps/e_utils"
S = "${WORKDIR}/e_utils"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir}"
