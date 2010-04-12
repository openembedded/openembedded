DESCRIPTION = "Python template engine and code generation tool"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
SRCNAME = "Cheetah"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/cheetahtemplate/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

RDEPENDS = "python-pickle python-pprint"

SRC_URI[md5sum] = "7845a2950ea850a13c488a26b61ac50a"
SRC_URI[sha256sum] = "70b618a03506831f59ba1ff8433907ee8d4ead5fc9f1b3f610d384e08a26938c"
