DESCRIPTION = "MOD/XM/S3M/IT plugin using libmodplug"
SECTION = "opie/codecs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "opie-mediaplayer1"
RDEPENDS = "opie-mediaplayer1"
PV = "1.1.9+cvs-${CVSDATE}"
APPNAME = "modplugin"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/multimedia/opieplayer "

S = "${WORKDIR}/opieplayer/modplug"

inherit opie

# FILES plugins/codecs/libmodplugin.so*

