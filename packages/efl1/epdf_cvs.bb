DESCRIPTION = "Epdf is the glue between EFL and libpoppler"
LICENSE = "BSD"
DEPENDS = "poppler evas ecore etk ewl"
PV = "0.1.0+cvs${SRCDATE}"

inherit efl1

SRC_URI = "${E_CVS};module=e17/proto/epdf"
S = "${WORKDIR}/epdf"

PACKAGES =+ "${PN}-tests"
FILES_${PN}-tests = "${bindir}/*_* ${datadir}"
FILES_${PN}-dev += "${bindir}/*-config"
FILES_${PN} = "${libdir}/*.so*"

