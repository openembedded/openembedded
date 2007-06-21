DESCRIPTION = "Enhance translates between glade .xml files and ETK"
LICENSE = "MIT"
DEPENDS = "exml"
PV = "0.0.0+cvs${SRCDATE}"

inherit efl1

SRC_URI = "${E_CVS};module=e17/libs/enhance"
S = "${WORKDIR}/enhance"

PACKAGES =+ "${PN}-tests"
FILES_${PN}-tests = "${bindir}/*_* ${datadir}"
FILES_${PN}-dev += "${bindir}/*-config"
FILES_${PN} = "${libdir}/*.so*"

