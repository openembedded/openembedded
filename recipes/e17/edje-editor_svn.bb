DESCRIPTION = "Edje-Editor is just that."
SECTION = "x11/devel"
LICENSE = "MIT BSD"
DEPENDS = "etk"
SRCNAME = "edje_editor"

PV = "0.0.0+svnr${SRCPV}"
PR = "r1"
SRCREV = "${EFL_SRCREV}"

inherit e
SRC_URI = "svn://svn.enlightenment.org/svn/e/OLD;module=${SRCNAME};proto=http"

FILES_${PN} += "${datadir}"
