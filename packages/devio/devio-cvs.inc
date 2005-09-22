# CVS based releases, disfavour these
DEFAULT_PREFERENCE = "-1"

include devio.inc

# this is a CVS only release
CVS_TAG ?= ";tag=${PV}"
SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/devio;method=pserver;module=devio${CVS_TAG}"

# This accesses the head version, anonymous pserver access is
# only updated once per day (and it is necessary to change
# 'jbowler' to the name of a developer with ssh access.)
#SRC_URI = "cvs://jbowler@cvs.sourceforge.net/cvsroot/devio;method=ext;rsh=ssh;tag=HEAD;module=devio"

# The source will end up in the subdirectory 'devio' - no release name
S = "${WORKDIR}/devio"
