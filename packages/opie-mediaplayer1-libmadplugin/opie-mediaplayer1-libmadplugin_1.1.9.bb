DESCRIPTION = "MP3 file plugin for opie-mediaplayer11 using libmad"
SECTION = "opie/codecs"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "opie-mediaplayer1 libmad"
RDEPENDS = "opie-mediaplayer1"

APPNAME = "madplugin"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/multimedia/opieplayer \
	   file://libmadplugin.pro"

S = "${WORKDIR}/opieplayer/libmad"
QMAKE_PROFILES = "libmadplugin.pro"

inherit opie

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/libmadplugin.pro ${S}/
}

# FILES plugins/codecs/libmadplugin.so
