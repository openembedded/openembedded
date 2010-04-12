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

SRC_URI[md5sum] = "7b2e951912d4bee9613c35244ca32673"
SRC_URI[sha256sum] = "5cd061fa5d4906d6aa7183393c98d070dc689cbb946c13bebab6d6e4ecdc2231"
