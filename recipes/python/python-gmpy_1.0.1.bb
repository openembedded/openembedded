DESCRIPTION = "General Multiprecision PYthon"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gmp"
SRCNAME = "gmpy"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-sources-101.zip"
S = "${WORKDIR}/${SRCNAME}"

inherit distutils
