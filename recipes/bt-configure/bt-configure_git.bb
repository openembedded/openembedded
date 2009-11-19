DESCRIPTION = "Python keyring"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "python python-pygtk bluez4"

PV = "1.0.0+gitr${SRCREV}"
PR = "r1"

ARCH_bt-configure = "all"

SRC_URI = "git://github.com/nytowl/BT-Configure.git;protocol=http"

inherit distutils

S = ${WORKDIR}/git

FILES_${PN} += "${datadir}"

