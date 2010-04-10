DESCRIPTION = "A sophisticated XML Processing Package for Python"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PSF"
SRCNAME = "pyxml"
PR = "ml1"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyxml/PyXML-${PV}.tar.gz"
S = "${WORKDIR}/PyXML-${PV}"

inherit distutils

RDEPENDS = "python-xml python-netclient"


SRC_URI[md5sum] = "1f7655050cebbb664db976405fdba209"
SRC_URI[sha256sum] = "9fab66f9584fb8e67aebd8745a5c97bf1c5a2e2e461adf68862bcec64e448c13"
