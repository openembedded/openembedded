DESCRIPTION = "Edje-Player is just that."
SECTION = "x11/devel"
LICENSE = "MIT BSD"
DEPENDS = "etk"
SRCNAME = "edje_editor"
PV = "0.0.0+svnr${SRCPV}"
PR = "r0"
SRCREV = "${EFL_SRCREV}"

inherit e

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/PROTO;module=edje_player;proto=http"
S = "${WORKDIR}/edje_player"

FILES_${PN} += "${datadir}"
