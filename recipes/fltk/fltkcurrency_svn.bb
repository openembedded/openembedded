DESCRIPTION = "FLTK Currency Converter"
HOMEPAGE = ""
AUTHOR = "Benjamin 'blindcoder' Schieder'
LICENSE = "GPLv2"
SECTION = "other/tool"
DEPENDS = "fltk"
RDEPENDS = "curl"
SRCREV = "10"
PV = "1.0+svnr${SRCPV}"
PR = "r0"
S = "${WORKDIR}/trunk"
RDEPENDS = "bash wget"

inherit autotools

SRC_URI = "svn://scavenger.homeip.net/svn/fltkcurrency;module=trunk;proto=http"
