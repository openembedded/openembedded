DESCRIPTION = "Enlightenment Window Manager Utilities"
DEPENDS = "virtual/ecore virtual/evas virtual/esmart edje eet ewl engrave virtual/imlib2 e epsilon"
LICENSE = "MIT"
PR = "r1"

inherit e

SRC_URI = "${E_CVS};module=e17/apps/e_utils;date=${PV}"
S = "${WORKDIR}/e_utils"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir}"
