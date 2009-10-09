DESCRIPTION = "Python keyring"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "python python-pygtk bluez4"

PV = "gitr${SRCREV}"
PR = "r1"

ARCH_bt-configure = "all"

SRC_URI = "git://github.com/nytowl/BT-Configure.git;protocol=http"

inherit distutils

S = ${WORKDIR}/git

FILES_${PN} += "${datadir}"

