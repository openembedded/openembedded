DESCRIPTION = "GPS diagnostic tool"
HOMEPAGE = "http://openmoko-agpsui.projects.openmoko.org/"
SECTION = "openmoko/apps"
LICENSE = "GPL"
DEPENDS = "gtk+"
PV = "0.1+svnr${SRCREV}"
PR = "r0"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/openmoko-agpsui;module=trunk;proto=https"

S = "${WORKDIR}/trunk"

inherit autotools pkgconfig
