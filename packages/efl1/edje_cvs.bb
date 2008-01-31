DESCRIPTION = "Edje is the Enlightenment graphical design & layout library"
DEPENDS = "eet evas ecore embryo edje-native"
LICENSE = "MIT BSD"
PV = "0.5.0.042+cvs${SRCDATE}"
PR = "r0"

inherit efl_library

PACKAGES =+ "${PN}-tools"
FILES_${PN}-tools = "${bindir}/edje_*"
