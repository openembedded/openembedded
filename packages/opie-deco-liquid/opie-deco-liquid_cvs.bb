DESCRIPTION = "Liquid window decoration style for Opie"
SECTION = "opie/decorations"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "libqtaux2"
PV = "1.1.8+cvs-${CVSDATE}"
APPNAME = "liquid"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/decorations/liquid "

S = "${WORKDIR}/liquid"

inherit opie
