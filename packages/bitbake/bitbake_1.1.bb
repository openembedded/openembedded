include bitbake.inc

# We don't need a toolchain...
INHIBIT_DEFAULT_DEPS = "1"

SRC_URI = "svn://svn.berlios.de/bitbake/tags;module=bitbake-${PV}"
S = "${WORKDIR}/bitbake-${PV}"

inherit distutils

include bitbake-package.inc
