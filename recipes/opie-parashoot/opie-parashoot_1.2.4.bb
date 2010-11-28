require ${PN}.inc

PR = "r2"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_games_parashoot.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_sounds.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2"

# FILES plugins/application/libparashoot.so* bin/parashoot apps/Games/parashoot.desktop pics/parashoot sounds/parashoot
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.xpm ${D}${palmtopdir}/pics/${APPNAME}/
        install -d ${D}${palmtopdir}/sounds/${APPNAME}/
        install -m 0644 ${WORKDIR}/sounds/${APPNAME}/*.wav ${D}${palmtopdir}/sounds/${APPNAME}/
}

