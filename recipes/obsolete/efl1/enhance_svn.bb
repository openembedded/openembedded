DESCRIPTION = "Enhance translates between glade .xml files and ETK"
LICENSE = "MIT"
DEPENDS = "exml"
PV = "0.0.1+svnr${SRCPV}"
PR = "r1"
SRCREV = "${EFL_SRCREV_1.0.0}"

inherit efl
SRC_URI = "${E_SVN}/OLD;module=${SRCNAME};proto=http;scmdata=keep"
S = "${WORKDIR}/${SRCNAME}"
