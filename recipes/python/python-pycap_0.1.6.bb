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

SRC_URI[md5sum] = "c90bc5382dede1a941e023e7bc27c473"
SRC_URI[sha256sum] = "961e37f49afeda70d89c21830751548a2ac4912a35122bf70bf29091eef5c4a0"
