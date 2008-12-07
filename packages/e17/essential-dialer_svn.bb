DESCRIPTION = "Simple Dialler based on Elementary and FSO"
SECTION = "base"
LICENSE = "GPLv2"
DEPENDS = "ecore edbus elementary libefso"
PV = "0.0.0+svnr${SRCREV}"
PR = "r2"

SRC_URI = "svn://svn.om.vptt.ch/trunk/;proto=http;module=essential-dialer"
S= "${WORKDIR}/essential-dialer"

inherit autotools pkgconfig

