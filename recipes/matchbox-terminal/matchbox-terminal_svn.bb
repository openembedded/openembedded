DESCRIPTION = "Matchbox Terminal"
LICENSE = "GPL"
DEPENDS = "gtk+ vte"
SECTION = "x11/utils"
SRCREV = "1612"
PV = "0.0+svnr${SRCPV}"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=${PN};proto=http"

S = "${WORKDIR}/${PN}"

inherit autotools pkgconfig
