DESCRIPTION = "Python Packet Capture Library"
SECTION = "devel/python"
PRIORITY = "optional"
RDEPENDS = "python-core"
DEPENDS = "libpcap libnet"
SRCNAME = "pycap"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
