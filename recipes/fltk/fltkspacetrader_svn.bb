DESCRIPTION = "Port of Space Trader - a space trading simulation originally available on the Palm"
HOMEPAGE = "http://www.crash-override.net/flyspray/index.php"
AUTHOR = "Benjamin 'blindcoder' Schieder'
LICENSE = "GPLv2"
SECTION = "x11/game"
DEPENDS = "fltk"
SRCREV = "190"
PV = "1.2+svnr${SRCPV}"
PR = "r0"
S = "${WORKDIR}/1.2-stable"

inherit autotools

SRC_URI = "svn://scavenger.homeip.net/svn/fltkspacetrader/tags;module=1.2-stable;proto=http"
