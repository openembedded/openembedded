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



SRC_URI[md5sum] = "8f5cb1d0b7c7d5437b260d9ba5362c74"
SRC_URI[sha256sum] = "e43251af443eb72a803a6aac3e984feb1f5df8124c64b55fceac6140ab76161e"
