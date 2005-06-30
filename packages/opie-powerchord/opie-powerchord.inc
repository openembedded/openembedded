DESCRIPTION = "Guitar Chord generator application"
SECTION = "opie/multimedia"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "powerchord"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES bin/powerchord apps/Applications/powerchord.desktop pics/powerchord share/powerchord
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
        install -d ${D}${palmtopdir}/share/${APPNAME}/
        install -m 0644 ${WORKDIR}/share/${APPNAME}/*.raw ${D}${palmtopdir}/share/${APPNAME}/
}

