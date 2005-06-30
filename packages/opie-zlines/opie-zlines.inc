DESCRIPTION = "ZLines"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "zlines"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libzlines.so* bin/zlines apps/Games/zlines.desktop pics/zlines
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

