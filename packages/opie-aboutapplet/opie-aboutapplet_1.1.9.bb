DESCRIPTION = "About Opie"
SECTION = "opie/applets"
PRIORITY = "optional"
MAINTAINER = "Rajko Albrecht <alwin@handhelds.org>"
LICENSE = "GPL"

APPNAME = "aboutapplet"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/applets/aboutapplet"
S = "${WORKDIR}/${APPNAME}"

inherit opie
