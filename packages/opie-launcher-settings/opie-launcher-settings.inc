DESCRIPTION = "Launcher settings dialog"
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "libqtaux2"
APPNAME = "launchersettings"


S = "${WORKDIR}/launcher"

inherit opie

# FILES plugins/application/liblaunchersettings.so* bin/launchersettings apps/Settings/launchersettings.desktop pics/launchersettings
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
} 
