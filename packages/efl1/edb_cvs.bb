DESCRIPTION = "Edb is a database library"
LICENSE = "MIT"
PV = "0.0.0+cvs${SRCDATE}"

inherit efl1

SRC_URI = "${E_CVS};module=e17/libs/edb"
S = "${WORKDIR}/edb"

PACKAGES =+ "${PN}-tests"
FILES_${PN}-tests = "${bindir}/*_* ${datadir}"
FILES_${PN}-dev += "${bindir}/*-config"
FILES_${PN} = "${libdir}/*.so*"

