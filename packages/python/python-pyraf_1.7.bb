DESCRIPTION = "PyRAF is a Python-based interface to IRAF."
HOMEPAGE = "http://www.stsci.edu/resources/software_hardware/pyraf"
AUTHOR = "Space Telescope Science Institute"
SECTION = "devel/python"
LICENSE = "AURA"
PR = "ml0"

SRC_URI = "ftp://ra.stsci.edu/pub/pyraf/release/pyraf-${PV}.tar.gz"
S = "${WORKDIR}/pyraf-${PV}"

inherit distutils

RDEPENDS = "python-numarray"

