DESCRIPTION = "Restart Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

APPNAME = "restartapplet"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/applets/restartapplet \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"

S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/applets/librestartapplet.so*
do_install() {
}

