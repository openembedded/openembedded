DESCRIPTION = "OPIE Mediaplayer1 OGG+MP3 pseudo package."
LICENSE = "GPL"
ALLOW_EMPTY = "1"
PACKAGES = "${PN}"
PACKAGE_ARCH = "all"

DEPENDS = "opie-mediaplayer1 \
           opie-mediaplayer1-libtremorplugin \
           opie-mediaplayer2-skin-default \
	   libogg \
           libvorbis \
           libmad "

RDEPENDS = "opie-mediaplayer1 \
           opie-mediaplayer1-libtremorplugin \
	   opie-mediaplayer2-skin-default \
	   libogg0 \
           libmad0 \
           libvorbis "
