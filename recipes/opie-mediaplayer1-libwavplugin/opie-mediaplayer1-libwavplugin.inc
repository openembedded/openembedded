DESCRIPTION = "WAV file plugin"
SECTION = "opie/codecs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "opie-mediaplayer1-core"
RDEPENDS = "opie-mediaplayer1-core"
APPNAME = "wavplugin"


S = "${WORKDIR}/opieplayer/${APPNAME}"

inherit opie

# FILES plugins/codecs/libwavplugin*
