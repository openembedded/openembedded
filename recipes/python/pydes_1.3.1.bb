DESCRIPTION = "Python DES implementation"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "python"

PR = "r1"
ARCH_pydes = "all"

SRC_URI = "http://twhiteman.netfirms.com/pyDES/pyDes-1.3.1.tar.gz"

inherit distutils

S = ${WORKDIR}/pyDes-1.3.1




SRC_URI[md5sum] = "e499fdde54e98be87324c0322311e034"
SRC_URI[sha256sum] = "4f1aae18f2aabb3559b8878d95a7228ebe6633fc4a88905935354ccdf2accc32"
