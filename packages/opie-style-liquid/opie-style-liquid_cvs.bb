DESCRIPTION = "Liquid style by Mosfet"
SECTION = "opie/styles"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = " libqtaux2"
PV = "1.1.9+cvs-${CVSDATE}"
APPNAME = "liquid"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/styles/liquid "

S = "${WORKDIR}/liquid"

inherit opie

# FILES
do_install() {
}

