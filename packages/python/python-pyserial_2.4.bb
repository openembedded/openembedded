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
