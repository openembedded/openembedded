DESCRIPTION = "Opie BluePin"
SECTION = "opie/applications"
PRIORITY = "optional"
DEPENDS = "libopietooth1"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PV = "1.1.9+cvs-${CVSDATE}"
APPNAME = "bluepin"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/net/opietooth/blue-pin"
S = "${WORKDIR}/blue-pin"

inherit opie
