DESCRIPTION = "Logout Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PV = "1.1.8+cvs-${CVSDATE}"
APPNAME = "logoutapplet"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/applets/logoutapplet \
           ${HANDHELDS_CVS};module=opie/apps"

S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES
do_install() {
}

