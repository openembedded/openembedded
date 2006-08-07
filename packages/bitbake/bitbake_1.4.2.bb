require bitbake.inc

# We don't need a toolchain...
INHIBIT_DEFAULT_DEPS = "1"

SRC_URI = "svn://svn.berlios.de/bitbake/tags;module=bitbake-${PV}"
S = "${WORKDIR}/bitbake-${PV}"

inherit distutils

require bitbake-package.inc

RDEPENDS += "python-shell python-lang python-textutils  python-pickle"

PR = "r1"


