DESCRIPTION = "FLTK Currency Converter"
HOMEPAGE = ""
AUTHOR = "Benjamin 'blindcoder' Schieder'
LICENSE = "GPLv2"
SECTION = "other/tool"
DEPENDS = "fltk"
RDEPENDS_${PN} = "curl"
SRCREV = "10"
PV = "1.0+svnr${SRCPV}"
PR = "r1"
S = "${WORKDIR}/trunk"
RDEPENDS_${PN} = "bash wget"

inherit autotools

SRC_URI = "svn://scavenger.homeip.net/svn/fltkcurrency;module=trunk;proto=http"
