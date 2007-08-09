DESCRIPTION = "MP3 file plugin for opie-mediaplayer11 using libmad"
SECTION = "opie/codecs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "opie-mediaplayer1-core libmad"
RDEPENDS = "opie-mediaplayer1-core"
APPNAME = "madplugin"


S = "${WORKDIR}/opieplayer/libmad"
QMAKE_PROFILES = "libmadplugin.pro"

inherit opie

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/libmadplugin.pro ${S}/
}

# FILES plugins/codecs/libmadplugin.so
