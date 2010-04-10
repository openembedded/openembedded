DESCRIPTION = "libusb Python Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
DEPENDS = "virtual/libusb0"
SRCNAME = "pyusb"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "9576c3e471e40e021fa44f36712bbd04"
SRC_URI[sha256sum] = "9991a999170c533c10dbff227a9d617ef592fd579edfc21a55f0b715a7d329db"
