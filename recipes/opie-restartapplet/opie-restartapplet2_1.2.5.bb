DESCRIPTION = "Restart Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "restartapplet"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_applets_restartapplet2.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2"

S = "${WORKDIR}/restartapplet2"

inherit opie

# FILES plugins/applets/librestartapplet.so*
do_install() {
}

