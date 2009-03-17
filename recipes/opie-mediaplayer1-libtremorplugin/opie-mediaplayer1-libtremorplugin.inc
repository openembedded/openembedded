DESCRIPTION = "Ogg file plugin using tremor"
SECTION = "opie/codecs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "opie-mediaplayer1-core tremor"
RDEPENDS = "opie-mediaplayer1-core"
APPNAME = "tremorplugin"


S = "${WORKDIR}/opieplayer/vorbis"

QMAKE_PROFILES = "vorbis.pro"

inherit opie

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/vorbis.pro ${S}/
}

# FILES plugins/codecs/libtremorplugin.so
