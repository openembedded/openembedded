DESCRIPTION = "Serial Port Support for Python"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "PSF"
SRCNAME = "pyserial"
RDEPENDS = "python-fcntl python-io"

PR = "r1"

SRC_URI = "http://www.vanille.de/mirror/${SRCNAME}-${PV}.tar.bz2"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

