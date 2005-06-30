DESCRIPTION = "BuzzWord Bingo"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "buzzword"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libbuzzword.so* bin/buzzword apps/Games/buzzword.desktop pics/buzzword/buzzword.png share/buzzword/buzzwords
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
        install -d ${D}${palmtopdir}/share/${APPNAME}/
        install -m 0644 ${WORKDIR}/share/${APPNAME}/buzzwords ${D}${palmtopdir}/share/${APPNAME}/
}

