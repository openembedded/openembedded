DESCRIPTION = "Engrave is an Edje Editing Library"
LICENSE = "MIT"
# also requires yacc and lex on host
DEPENDS = "evas ecore"
PV = "0.0.0+cvs${SRCDATE}"

inherit efl1

SRC_URI = "${E_CVS};module=e17/libs/engrave"
S = "${WORKDIR}/engrave"

PACKAGES =+ "${PN}-tests"
FILES_${PN}-tests = "${bindir}/*_* ${datadir}"
FILES_${PN}-dev += "${bindir}/*-config"
FILES_${PN} = "${libdir}/*.so*"

