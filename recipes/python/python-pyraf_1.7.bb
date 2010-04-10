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


SRC_URI[md5sum] = "9a728aef7bebcd54abc103b00e2e1de6"
SRC_URI[sha256sum] = "dc0f68f2d22cad2166ae3912e20713bb29df1e1450dff18eb426a74ef4087d2a"
