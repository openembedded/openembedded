DESCRIPTION = "SFCave for the Zaurus. Fly the dot though the cave avoiding the walls."
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "sfcave"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES bin/sfcave apps/Games/sfcave.desktop pics/sfcave
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

