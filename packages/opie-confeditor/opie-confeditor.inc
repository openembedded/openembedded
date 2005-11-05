DESCRIPTION = "An enditor for the ~/Settings/*.conf files"
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "confedit"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES bin/confedit apps/Settings/confedit.desktop pics/confedit/confedit.png plugins/application/libconfedit.so*
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

