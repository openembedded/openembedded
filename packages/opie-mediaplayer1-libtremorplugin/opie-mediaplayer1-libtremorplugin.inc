DESCRIPTION = "Ogg file plugin using tremor"
SECTION = "opie/codecs"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "opie-mediaplayer1 tremor"
RDEPENDS = "opie-mediaplayer1"
APPNAME = "tremorplugin"


S = "${WORKDIR}/opieplayer/vorbis"

QMAKE_PROFILES = "vorbis.pro"

inherit opie

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/vorbis.pro ${S}/
}

# FILES plugins/codecs/libtremorplugin.so
