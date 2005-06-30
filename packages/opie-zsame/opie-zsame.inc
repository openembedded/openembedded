DESCRIPTION = "ZSame"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "zsame"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libzsame.so* bin/zsame apps/Games/zsame.desktop pics/zsame
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

