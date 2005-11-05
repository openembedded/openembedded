DESCRIPTION = "A Pure Python Expect like Module for Python"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "PSF"
RDEPENDS = "python-core python-io python-terminal python-resource python-fcntl"
SRCNAME = "pexpect"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tgz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
