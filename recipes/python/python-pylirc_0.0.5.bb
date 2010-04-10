DESCRIPTION = "Python lirc module. See http://www.lirc.org for more info on lirc"
SECTION = "devel/python"
PRIORITY = "optional"
DEPENDS = "lirc"
LICENSE = "LGPL"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/pylirc/pylirc-${PV}.tar.gz"
S = "${WORKDIR}/pylirc-${PV}"

inherit distutils

SRC_URI[md5sum] = "4e3b6b50485610e273fededdb25b47ad"
SRC_URI[sha256sum] = "a78315e1ddf5af61cf91000a4b2f8e2df0841edd97b2596b2e0c5505bf8330a2"
