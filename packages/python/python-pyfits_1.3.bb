DESCRIPTION = "PyFITS provides an interface to FITS formatted files under the Python scripting language."
HOMEPAGE = "http://www.stsci.edu/resources/software_hardware/pyfits"
AUTHOR = "Space Telescope Science Institute"
RDEPENDS = "python-numpy"
SECTION = "devel/python"
LICENSE = "AURA"
PR = "ml0"

SRC_URI = "http://www.stsci.edu/resources/software_hardware/pyfits/pyfits-${PV}.tar.gz"
S = "${WORKDIR}/pyfits-${PV}"

inherit distutils
