DESCRIPTION = "libusb Python Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
DEPENDS = "libusb"
SRCNAME = "pyusb"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
