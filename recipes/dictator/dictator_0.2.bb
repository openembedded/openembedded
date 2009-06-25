DESCRIPTION = "Call recodering program for Neo Smartphones"
SECTION = "utils"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "python python-pygtk python-xml python-netclient pydes python-audio"
PR="r2"

ARCH_pyring = "all"

SRC_URI = "http://home.htw-berlin.de/~s0526295/dictator-0.2.tar.gz"

inherit distutils

S = ${WORKDIR}/dictator-${PV}

FILES_${PN} += " ${sysconfdir}/dictator.conf ${datadir}"


