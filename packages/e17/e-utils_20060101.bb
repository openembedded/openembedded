DESCRIPTION = "Enlightenment Window Manager Utilities"
DEPENDS = "virtual/ecore virtual/evas virtual/esmart edje eet ewl engrave virtual/imlib2 e epsilon"
LICENSE = "MIT"
SECTION = "e/apps"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
PR = "r1"

inherit autotools

SRC_URI = "cvs://anonymous@thinktux.net/root;module=e17/apps/e_utils;date=${PV}"
S = "${WORKDIR}/e_utils"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir}"
