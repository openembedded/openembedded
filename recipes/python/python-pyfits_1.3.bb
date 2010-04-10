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

SRC_URI[md5sum] = "59c3c8c714336eab7760b7d320e124c3"
SRC_URI[sha256sum] = "a6b01c9d75e7955765019581700bd6ac344457b327522facedaf4cff9e86093c"
