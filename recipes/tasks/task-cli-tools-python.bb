DESCRIPTION = "A set of python-based command line tools"
SECTION = "console"
LICENSE = "MIT"
PV = "1.0"
PR = "r9"

inherit task

RDEPENDS_${PN} = "\
  mdbus2 \
  mterm2 \
"
