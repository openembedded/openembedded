DESCRIPTION = "A set of python-based command line tools"
SECTION = "console"
LICENSE = "MIT"
PV = "1.0"
PR = "r8"

inherit task

RDEPENDS_${PN} = "\
  mickeydbus \
  mickeyterm \
"
