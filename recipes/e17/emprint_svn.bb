DESCRIPTION = "Emprint is a utility for taking screenshots of the entire screen, a specific window, or a specific region."
LICENSE = "MIT BSD"
DEPENDS = "imlib2 virtual/libx11 ecore evas edje eina"
PV = "0.0.1+svnr${SRCPV}"

inherit e

SRCREV = "${EFL_SRCREV}"
SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/;module=emprint;proto=http"
S = "${WORKDIR}/emprint"

FILES_${PN}-dbg += "${libdir}/${PN}/modules/.debug"
