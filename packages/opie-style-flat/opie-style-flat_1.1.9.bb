DESCRIPTION = "Simple, flat widget style for Opie"
SECTION = "opie/styles"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

APPNAME = "flatstyle"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/styles/flat "

S = "${WORKDIR}/flat"

inherit opie
