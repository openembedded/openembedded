DESCRIPTION = "Edje is a complex graphical design & layout library."
# can also install vim data files
DEPENDS = "eet evas ecore embryo edje-native"
LICENSE = "MIT BSD"
PV = "0.5.0.41+cvs${SRCDATE}"
PR = "r2"

inherit efl_library

PACKAGES =+ "${PN}-tools"
FILES_${PN}-tools = "${bindir}/edje_*"
