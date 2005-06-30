DESCRIPTION = "Yatzee-like game"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "oyatzee"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES bin/oyatzee apps/Games/oyatzee.desktop pics/oyatzee
do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

