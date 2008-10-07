require ${PN}.inc

PR = "r1"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/games/parashoot \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/sounds \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"

# FILES plugins/application/libparashoot.so* bin/parashoot apps/Games/parashoot.desktop pics/parashoot sounds/parashoot
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.xpm ${D}${palmtopdir}/pics/${APPNAME}/
        install -d ${D}${palmtopdir}/sounds/${APPNAME}/
        install -m 0644 ${WORKDIR}/sounds/${APPNAME}/*.wav ${D}${palmtopdir}/sounds/${APPNAME}/
}

