DESCRIPTION = "Python lirc module. See http://www.lirc.org for more info on lirc"
SECTION = "devel/python"
PRIORITY = "optional"
DEPENDS = "lirc"
LICENSE = "LGPL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/pylirc/pylirc-${PV}.tar.gz"
S = "${WORKDIR}/pylirc-${PV}"

inherit distutils
