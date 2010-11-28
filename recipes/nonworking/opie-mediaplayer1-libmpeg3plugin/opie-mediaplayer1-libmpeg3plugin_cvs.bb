DESCRIPTION = "Mpeg video file plugin using libmad"
SECTION = "opie/codecs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "opie-mediaplayer1"
RDEPENDS_${PN} = "opie-mediaplayer1"
PV = "${OPIE_CVS_PV}"
PR = "r2"
APPNAME = "mpeg3plugin"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=core/multimedia/opieplayer"

S = "${WORKDIR}/opieplayer/libmpeg3"

inherit opie

EXTRA_QMAKEVARS_POST += "DEFINES+=USE_FIXED_POINT"

# FILES plugins/codecs/libmpeg3plugin.so
