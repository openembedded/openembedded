DESCRIPTION = "The classic Opie media player (core)"
SECTION = "opie/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "libqtaux2"
RDEPENDS = "opie-mediaplayer2-skin-default"
APPNAME = "opieplayer"
APPTYPE = "binary"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES bin/opieplayer pics/opieplayer apps/Applications/opieplayer.desktop
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/skins/default/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

