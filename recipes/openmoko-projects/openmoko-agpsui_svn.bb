DESCRIPTION = "GPS diagnostic tool"
HOMEPAGE = "http://openmoko-agpsui.projects.openmoko.org/"
SECTION = "openmoko/apps"
LICENSE = "GPL"
DEPENDS = "gtk+"
SRCREV = "7"
PV = "0.1+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/openmoko-agpsui;module=trunk;proto=http \
file://fix-configure-for-new-autotools.patch;patch=1;pnum=2"

S = "${WORKDIR}/trunk"

inherit autotools pkgconfig
