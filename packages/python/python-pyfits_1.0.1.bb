DESCRIPTION = "PyFITS provides an interface to FITS formatted files under the Python scripting language."
HOMEPAGE = "http://www.stsci.edu/resources/software_hardware/pyfits"
AUTHOR = "Space Telescope Science Institute"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de"
RDEPENDS = "python-numarray"
SECTION = "devel/python"
LICENSE = "AURA"
PR = "ml0"

SRC_URI = "ftp://ra.stsci.edu/pub/pyfits/pyfits-${PV}.tar.gz"
S = "${WORKDIR}/pyfits-${PV}"

inherit distutils
