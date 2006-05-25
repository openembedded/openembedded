DESCRIPTION = "PyRAF is a Python-based interface to IRAF."
HOMEPAGE = "http://www.stsci.edu/resources/software_hardware/pyfits"
AUTHOR = "Space Telescope Science Institute"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de"
RDEPENDS = "python-numarray"
SECTION = "devel/python"
LICENSE = "AURA"
PR = "ml0"

SRC_URI = "ftp://ra.stsci.edu/pub/pyraf/v2.3/pyraf-${PV}.tar.gz"
S = "${WORKDIR}/pyraf-${PV}"

inherit distutils

