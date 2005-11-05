DESCRIPTION = "bounce"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "bounce"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libbounce.so* bin/bounce apps/Games/bounce.desktop pics/bounce/*.png
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

