DESCRIPTION = "Serial Port Support for Python"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PSF"
SRCNAME = "pyserial"
RDEPENDS = "python-fcntl python-io"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.zip"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

