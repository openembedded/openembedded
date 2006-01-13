DESCRIPTION = "Mpeg video file plugin using libmad"
SECTION = "opie/codecs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "opie-mediaplayer1"
RDEPENDS = "opie-mediaplayer1"
PV = "${OPIE_CVS_PV}"
APPNAME = "mpeg3plugin"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/multimedia/opieplayer"

S = "${WORKDIR}/opieplayer/libmpeg3"

inherit opie

EXTRA_QMAKEVARS_POST += "DEFINES+=USE_FIXED_POINT"

# FILES plugins/codecs/libmpeg3plugin.so
