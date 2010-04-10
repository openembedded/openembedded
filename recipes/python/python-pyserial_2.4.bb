DESCRIPTION = "Serial Port Support for Python"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PSF"
SRCNAME = "pyserial"
PR = "ml1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

# FIXME might stop packaging serialwin32 and serialjava files

RDEPENDS = "\
  python-fcntl \
  python-io \
  python-stringold \
"

SRC_URI[md5sum] = "eec19df59fd75ba5a136992897f8e468"
SRC_URI[sha256sum] = "6b6a9e3d2fd5978c92c843e0109918a4bcac481eecae316254481c0e0f7e73c8"
