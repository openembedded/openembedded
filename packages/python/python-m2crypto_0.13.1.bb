DESCRIPTION = "A Python crypto and SSL toolkit"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "openssl swig-native"
LICENSE = "BSD"
SRCNAME = "M2Crypto"

SRC_URI = "http://sandbox.rulemaker.net/ngps/Dist/m2crypto-0.13.zip \
	   file://0.13p1.patch;patch=1;pnum=0"
S = "${WORKDIR}/m2crypto-0.13"

inherit distutils

