DESCRIPTION = "Suspend Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

APPNAME = "suspendapplet"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/applets/suspendapplet \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"

S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES
do_install() {
}

