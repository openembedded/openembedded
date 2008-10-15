DESCRIPTION = "Edje-Editor is just that."
SECTION = "x11/devel"
LICENSE = "MIT BSD"
DEPENDS = "etk"
SRCNAME = "edje_editor"

PV = "0.0.0+svnr${SRCREV}"
PR = "r1"

inherit e

FILES_${PN} += "${datadir}"
