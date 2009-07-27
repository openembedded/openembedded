DESCRIPTION = "Python Bindings for libphone-utils"
SECTION = "devel/python"

PV = "0.0.2+gitr${SRCPV}"
PR = "r0"


SRC_URI = "git://git.shr-project.org/repo/libphone-utils.git;protocol=http;branch=master"
S = "${WORKDIR}/git/src/python"

inherit distutils
