DESCRIPTION = "WAV file plugin"
SECTION = "opie/codecs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "opie-mediaplayer1"
RDEPENDS = "opie-mediaplayer1"

APPNAME = "wavplugin"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/multimedia/opieplayer "

S = "${WORKDIR}/opieplayer/${APPNAME}"

inherit opie

# FILES plugins/codecs/libwavplugin*
