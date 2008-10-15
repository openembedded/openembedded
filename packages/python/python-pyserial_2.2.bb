DESCRIPTION = "Serial Port Support for Python"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PSF"
SRCNAME = "pyserial"
RDEPENDS = "python-fcntl python-io python-stringold"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.zip"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

# FIXME might stop packaging serialwin32 and serialjava files

