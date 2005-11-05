include bitbake.inc

# Don't use the tip of svn by default
DEFAULT_PREFERENCE = "-1"

# We don't need a toolchain...
INHIBIT_DEFAULT_DEPS = "1"

PV = "0.0svn${CVSDATE}"
SRC_URI = "svn://svn.berlios.de/bitbake/trunk;module=bitbake"
# SRC_URI = "svn+ssh://svn.berlios.de/bitbake/trunk;module=bitbake"
S = "${WORKDIR}/bitbake"

inherit distutils

include bitbake-package.inc
