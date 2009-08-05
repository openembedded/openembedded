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
