require bitbake.inc

# We don't need a toolchain...
INHIBIT_DEFAULT_DEPS = "1"

SRC_URI = "http://download.berlios.de/bitbake/bitbake-${PV}.tar.gz"

S = "${WORKDIR}/bitbake-${PV}"

inherit distutils

require bitbake-package.inc

RDEPENDS += "python-shell python-lang python-textutils  python-pickle"
