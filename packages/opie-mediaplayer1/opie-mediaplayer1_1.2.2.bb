DESCRIPTION = "The classic Opie media player (core+plugins)."
LICENSE = "GPL"
ALLOW_EMPTY = "1"
PACKAGES = "${PN}"
PACKAGE_ARCH = "all"
RDEPENDS = "opie-mediaplayer1-core"
RRECOMMENDS = "opie-mediaplayer1-libmadplugin opie-mediaplayer1-libwavplugin \
opie-mediaplayer1-libmodplugin opie-mediaplayer1-libtremorplugin"

PR = "r2"
