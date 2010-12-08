DESCRIPTION = "Edje_Viewer is just that."
LICENSE = "MIT BSD"
DEPENDS = "elementary"
PV = "0.0.0+svnr${SRCPV}"
PR = "r3"
SRCREV = "${EFL_SRCREV}"

inherit e

SRCNAME = "edje_viewer"

FILES_${PN} += "${datadir}"
