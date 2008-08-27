DESCRIPTION = "Enlightenment Window Manager Utilities"
DEPENDS = "eet evas ecore edje esmart ewl engrave"
LICENSE = "MIT BSD"
PV = "0.0.0+svnr${SRCREV}"
PR = "r1"

inherit e

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/OLD;module=e_utils;proto=http"
S = "${WORKDIR}/e_utils"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir}"
