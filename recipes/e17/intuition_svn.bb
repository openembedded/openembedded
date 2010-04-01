DESCRIPTION = "Intuition a prototype context dependent mobile search engine"
SECTION = "x11"
LICENSE = "GPLv2"
DEPENDS = "elementary sqlite"
PV = "0.2.0+svnr${SRCPV}"
PR = "r0"
SRCREV = "194"

SRC_URI = "svn://svn.om.vptt.ch/trunk/;proto=http;module=intuition"
S = "${WORKDIR}/intuition"

inherit autotools pkgconfig
