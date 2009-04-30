DESCRIPTION = "Simple Dialer based on Elementary and FSO"
SECTION = "x11"
LICENSE = "GPLv2"
DEPENDS = "ecore edbus elementary libefso"
PV = "0.1.0.0+svnr${SRCPV}"

SRC_URI = "svn://svn.om.vptt.ch/trunk/;proto=http;module=essential-dialer"
S = "${WORKDIR}/essential-dialer"

inherit autotools pkgconfig
