DESCRIPTION = "Polished window decoration style for Opie"
SECTION = "opie/decorations"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

APPNAME = "polished"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/decorations/polished "

S = "${WORKDIR}/polished"

inherit opie
