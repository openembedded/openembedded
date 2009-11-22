DESCRIPTION = "Python Bindings for libphone-utils"
SECTION = "devel/python"
DEPENDS = "libphone-utils"
PV = "0.0.2+gitr${SRCREV}"
PR = "r1"

SRC_URI = "git://git.shr-project.org/repo/libphone-utils.git;protocol=http;branch=master"
S = "${WORKDIR}/git/src/python"

inherit setuptools
