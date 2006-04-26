DESCRIPTION = "General Multiprecision PYthon"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
DEPENDS = "gmp"
SRCNAME = "gmpy"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-sources-101.zip"
S = "${WORKDIR}/${SRCNAME}"

inherit distutils
