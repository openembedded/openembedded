DESCRIPTION = "PyRAF is a Python-based interface to IRAF."
HOMEPAGE = "http://www.stsci.edu/resources/software_hardware/pyfits"
AUTHOR = "Space Telescope Science Institute"
RDEPENDS = "python-numarray"
SECTION = "devel/python"
LICENSE = "AURA"
PR = "ml0"

SRC_URI = "ftp://ra.stsci.edu/pub/pyraf/v2.5/pyraf-${PV}.tar.gz"
S = "${WORKDIR}/pyraf"

inherit distutils

