DESCRIPTION = "Opie Phase disguishes oneself through its' simple, clean and slick look. \
It is based on http://www.usermode.org/code.html Phase 0.4."
SECTION = "opie/styles"
PRIORITY = "optional"
LICENSE = "GPL"

APPNAME = "phasestyle"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/styles/phase"
S = "${WORKDIR}/phase"

inherit opie
