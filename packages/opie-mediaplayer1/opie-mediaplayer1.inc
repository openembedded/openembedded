DESCRIPTION = "The classic Opie media player"
SECTION = "opie/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "opie-mediaplayer2-skin-default"
RDEPENDS = "opie-mediaplayer2-skin-default"
RRECOMMENDS = "opie-mediaplayer1-libmadplugin opie-mediaplayer1-libwavplugin \
opie-mediaplayer1-libmodplugin opie-mediaplayer1-libtremorplugin"
APPNAME = "opieplayer"
APPTYPE = "binary"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES bin/opieplayer pics/opieplayer apps/Applications/opieplayer.desktop
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/skins/default/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

