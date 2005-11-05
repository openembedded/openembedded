DESCRIPTION = "Game: solitaire card games"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "patience"


S = "${WORKDIR}/solitaire"

inherit opie

# FILES plugins/application/libpatience.so* bin/patience apps/Games/patience.desktop pics/cards
do_install() {
        install -d ${D}${palmtopdir}/pics/cards/
        install -m 0644 ${WORKDIR}/pics/cards/*.png ${D}${palmtopdir}/pics/cards/
}


