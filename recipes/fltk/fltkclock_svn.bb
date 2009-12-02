DESCRIPTION = "FLTK Worldclock Application"
HOMEPAGE = "http://www.crash-override.net/omworldclock.html"
AUTHOR = "Benjamin 'blindcoder' Schieder'
LICENSE = "PD/GPLv2"
SECTION = "x11/tool"
DEPENDS = "fltk"
SRCREV = "45"
PV = "1.0+svnr${SRCPV}"
PR = "r0"
S = "${WORKDIR}/trunk"

inherit autotools

SRC_URI = "svn://scavenger.homeip.net/svn/fltkworldclock;module=trunk;proto=http"
