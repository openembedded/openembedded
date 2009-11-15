DESCRIPTION = "Edje_Viewer is just that."
DEPENDS = "etk"
LICENSE = "MIT BSD"
PV = "0.0.0+svnr${SRCPV}"
PR = "r2"

inherit e

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk;module=edje_viewer;proto=http"
S = "${WORKDIR}/edje_viewer"

FILES_${PN} += "${datadir}"
