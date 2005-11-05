DESCRIPTION = "Restart Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PV = "1.2.1+cvs-${CVSDATE}"
APPNAME = "restartapplet"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/applets/restartapplet2 \
           ${HANDHELDS_CVS};module=opie/apps"

S = "${WORKDIR}/restartapplet2"

inherit opie

# FILES plugins/applets/librestartapplet.so*
do_install() {
}

