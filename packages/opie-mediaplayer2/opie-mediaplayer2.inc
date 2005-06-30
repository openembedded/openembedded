DESCRIPTION = "The next generation mediaplayer for Opie - based libxine. \
It plays mp3, mpeg, wav, ogg, quicktime, divx, etc. and is capable of streaming."
SECTION = "opie/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Team Opie <opie@handhelds.org>"
DEPENDS = "libxine-opie libqtaux2 opie-mediaplayer2-skin-default"
RDEPENDS = "opie-mediaplayer2-skin"
RRECOMMENDS = "opie-mediaplayer2-skin-default libxine-plugin-ao-out-oss libxine-plugin-decode-mad \
libxine-plugin-dmx-audio libxine-plugin-dmx-mpeg libxine-plugin-inp-file "
APPNAME = "opieplayer2"

S = "${WORKDIR}/${APPNAME}"

inherit opie

QMAKE_PROFILES = "opieplayer2.pro"

do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/ ${S}${palmtopdir}/apps/Applications/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}
