DESCRIPTION = "VT Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

APPNAME = "vtapplet"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/applets/vtapplet \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"

S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES
do_install() {
}

