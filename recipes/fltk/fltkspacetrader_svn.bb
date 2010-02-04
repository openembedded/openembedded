DESCRIPTION = "Port of Space Trader - a space trading simulation originally available on the Palm"
HOMEPAGE = "http://www.crash-override.net/flyspray/index.php"
AUTHOR = "Benjamin 'blindcoder' Schieder'
LICENSE = "GPLv2"
SECTION = "x11/game"
DEPENDS = "fltk"
SRCREV = "62"
PV = "1.0+svnr${SRCPV}"
PR = "r0"
S = "${WORKDIR}/trunk"

inherit autotools

SRC_URI = "svn://scavenger.homeip.net/svn/fltkspacetrader;module=trunk;proto=http"
