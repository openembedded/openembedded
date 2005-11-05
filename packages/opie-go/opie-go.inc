DESCRIPTION = "The game of Go"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "go"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libgo.so* bin/go apps/Games/go.desktop pics/go
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

