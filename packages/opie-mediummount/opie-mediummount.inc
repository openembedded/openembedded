DESCRIPTION = "Medium mount configuration"
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "mediummount"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libmediummount.so* bin/mediummount apps/Settings/medium.desktop pics/mediummount/*
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

