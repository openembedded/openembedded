DESCRIPTION = "Fifteen pieces game"
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "fifteen"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libfifteen.so* bin/fifteen apps/Games/fifteen.desktop pics/fifteen
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

