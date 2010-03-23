DESCRIPTION = "Edje_Viewer is just that."
LICENSE = "MIT BSD"
DEPENDS = "elementary"
PV = "0.0.0+svnr${SRCPV}"
PR = "r3"

inherit e

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk;module=edje_viewer;proto=http"
S = "${WORKDIR}/edje_viewer"

FILES_${PN} += "${datadir}"
