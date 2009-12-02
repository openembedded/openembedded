DESCRIPTION = "FLTK Cocktail Bar Application"
HOMEPAGE = "http://www.crash-override.net/omcocktailbar.html"
AUTHOR = "Benjamin 'blindcoder' Schieder'
LICENSE = "GPLv2"
SECTION = "x11/tool"
DEPENDS = "fltk zlib cairo"
RDEPENDS = "curl"
SRCREV = "52"
PV = "1.0+svnr${SRCPV}"
PR = "r0"
S = "${WORKDIR}/trunk"

inherit autotools

SRC_URI = "svn://scavenger.homeip.net/svn/fltkcocktailbar;module=trunk;proto=http"
