DESCRIPTION = "Opie BluePin"
SECTION = "opie/applications"
PRIORITY = "optional"
DEPENDS = "libopietooth1"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

APPNAME = "bluepin"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/net/opietooth/blue-pin"
S = "${WORKDIR}/blue-pin"

inherit opie
