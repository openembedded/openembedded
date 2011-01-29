DESCRIPTION = "Exml is a generic XML parser wrapper."
LICENSE = "MIT"
DEPENDS = "libxml2 libxslt ecore"
PV = "0.1.1+svnr${SRCPV}"
PR = "r2"
SRCREV = "${EFL_SRCREV_1.0.0}"

inherit efl
SRC_URI = "${E_SVN}/BROKEN;module=${SRCNAME};proto=http;scmdata=keep"
S = "${WORKDIR}/${SRCNAME}"
