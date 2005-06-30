DESCRIPTION = "Restart Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "restartapplet"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/applets/librestartapplet.so*
do_install() {
}

