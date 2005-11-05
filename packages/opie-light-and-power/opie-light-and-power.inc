DESCRIPTION = "Light and Power settings dialog"
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "light-and-power"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/liblight-and-power.so* bin/light-and-power apps/Settings/light.desktop pics/lightandpower
do_install() {
        install -d ${D}${palmtopdir}/pics/lightandpower/
        install -m 0644 ${WORKDIR}/pics/lightandpower/*.png ${D}${palmtopdir}/pics/lightandpower/
}

