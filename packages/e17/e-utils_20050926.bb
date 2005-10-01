DESCRIPTION = "Enlightenment Window Manager Utilities"
DEPENDS = "virtual/ecore virtual/evas virtual/esmart edje eet ewl engrave virtual/imlib2 e epsilon"
LICENSE = "MIT"
SECTION = "e/apps"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
CVSDATE = "${PV}"
PR = "r1"

inherit autotools

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/apps/e_utils"
S = "${WORKDIR}/e_utils"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir}"
