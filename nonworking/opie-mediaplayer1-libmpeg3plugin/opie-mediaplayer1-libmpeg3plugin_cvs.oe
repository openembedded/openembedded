DESCRIPTION = "Mpeg video file plugin using libmad"
SECTION = "opie/codecs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "opie-mediaplayer1"
RDEPENDS = "opie-mediaplayer1"
PV = "1.1.6-cvs-${CVSDATE}"
APPNAME = "mpeg3plugin"

SRC_URI = "cvs://anoncvs:anoncvs@cvs.handhelds.org/cvs;module=opie/core/multimedia/opieplayer;date=${CVSDATE} "

S = "${WORKDIR}/opieplayer/libmpeg3"

inherit opie

EXTRA_QMAKEVARS_POST += "DEFINES+=USE_FIXED_POINT"

# FILES plugins/codecs/libmpeg3plugin.so
