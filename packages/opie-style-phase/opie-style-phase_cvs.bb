DESCRIPTION = "Opie Phase disguishes oneself through its' simple, clean and slick look. \
It is based on http://www.usermode.org/code.html Phase 0.4."
SECTION = "opie/styles"
PRIORITY = "optional"
LICENSE = "GPL"
PV = "1.1.9+cvs-${CVSDATE}"
APPNAME = "phasestyle"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/styles/phase"
S = "${WORKDIR}/phase"

inherit opie
