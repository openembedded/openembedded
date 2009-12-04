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



