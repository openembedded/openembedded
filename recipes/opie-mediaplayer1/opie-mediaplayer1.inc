DESCRIPTION = "The classic Opie media player (core+plugins)."
LICENSE = "GPL"
ALLOW_EMPTY = "1"
PACKAGE_ARCH = "all"
RDEPENDS_${PN} = "opie-mediaplayer1-core"
RRECOMMENDS_${PN} = "opie-mediaplayer1-libmadplugin opie-mediaplayer1-libwavplugin \
opie-mediaplayer1-libmodplugin opie-mediaplayer1-libtremorplugin"

