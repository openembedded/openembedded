DESCRIPTION = "FLTK Weight Watchers Points Calculator"
HOMEPAGE = "http://www.crash-override.net/omwwpointcal.html"
AUTHOR = "Benjamin 'blindcoder' Schieder'
LICENSE = "GPLv2"
SECTION = "x11/tool"
DEPENDS = "fltk"
SRCREV = "2"
PV = "1.0+svnr${SRCPV}"
PR = "r0"
S = "${WORKDIR}/trunk"

inherit autotools

SRC_URI = "svn://scavenger.homeip.net/svn/fltkwwpointcal;module=trunk;proto=http"
