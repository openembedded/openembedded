DESCRIPTION = "Restart Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
LICENSE = "GPL"
PV = "${OPIE_GIT_PV}"
APPNAME = "restartapplet"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=core/applets/restartapplet2 \
           ${OPIE_GIT};protocol=git;subpath=apps"

S = "${WORKDIR}/restartapplet2"

inherit opie

# FILES plugins/applets/librestartapplet.so*
do_install() {
}

