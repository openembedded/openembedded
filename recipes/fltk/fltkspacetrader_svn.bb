DESCRIPTION = "Port of Space Trader - a space trading simulation originally available on the Palm"
HOMEPAGE = "http://www.crash-override.net/flyspray/index.php"
AUTHOR = "Benjamin 'blindcoder' Schieder'
LICENSE = "GPLv2"
SECTION = "x11/game"
DEPENDS = "fltk"
SRCREV = "110"
PV = "1.0+svnr${SRCPV}"
PR = "r0"
S = "${WORKDIR}/1.0-stable"

inherit autotools

SRC_URI = "svn://scavenger.homeip.net/svn/fltkspacetrader/tags;module=1.0-stable;proto=http"
