DESCRIPTION = "PyFITS provides an interface to FITS formatted files under the Python scripting language."
HOMEPAGE = "http://www.stsci.edu/resources/software_hardware/pyfits"
AUTHOR = "Space Telescope Science Institute"
# Warning: pyfits will require python-numpy in 2008
RDEPENDS = "python-numarray"
SECTION = "devel/python"
LICENSE = "AURA"
PR = "ml0"

SRC_URI = "http://www.stsci.edu/resources/software_hardware/pyfits/pyfits-${PV}.tar.gz"
S = "${WORKDIR}/pyfits"

inherit distutils
