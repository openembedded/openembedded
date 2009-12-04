DESCRIPTION = "FLTK Hacker's Diet Application"
HOMEPAGE = "http://www.crash-override.net/omhackersdiet.html"
AUTHOR = "Benjamin 'blindcoder' Schieder'
LICENSE = "GPLv2"
SECTION = "x11/tool"
DEPENDS = "fltk"
RDEPENDS = "curl"
SRCREV = "67"
PV = "1.0+svnr${SRCPV}"
PR = "r0"
S = "${WORKDIR}/trunk"

inherit autotools

SRC_URI = "svn://scavenger.homeip.net/svn/fltkhackdiet;module=trunk;proto=http"
