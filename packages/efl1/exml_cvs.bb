DESCRIPTION = "Exml is a generic XML parser wrapper."
LICENSE = "MIT"
DEPENDS = "libxml2 libxslt ecore"

inherit efl1

SRC_URI = "${E_CVS};module=e17/libs/exml"
S = "${WORKDIR}/exml"

PACKAGES =+ "${PN}-tests"
FILES_${PN}-tests = "${bindir}/*_* ${datadir}"
FILES_${PN}-dev += "${bindir}/*-config"
FILES_${PN} = "${libdir}/*.so*"
