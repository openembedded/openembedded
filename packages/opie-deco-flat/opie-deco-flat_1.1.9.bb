DESCRIPTION = "Simple, flat window decoration style for Opie"
SECTION = "opie/decorations"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

APPNAME = "flat"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/decorations/flat "

S = "${WORKDIR}/flat"

inherit opie
