DESCRIPTION = "Enlightenment Window Manager Utilities"
DEPENDS = "freetype eet evas-x11 ecore-x11 edje engrave esmart epsilon ewl imlib2-x11 e17"
LICENSE = "MIT"
SECTION = "e/apps"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
CVSDATE = "${PV}"
PR = "r0"

inherit autotools

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/apps/e_utils"
S = "${WORKDIR}/e_utils"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir}"
