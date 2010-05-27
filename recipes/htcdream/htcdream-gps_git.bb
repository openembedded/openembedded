DESCRIPTION = "HTC Dream GPS utility"
SECTION = "console/utils"
LICENSE = "GPL"
SRCREV = "c0339e14de385723e32667a3b815eef74c040b9b"
PV = "1.0+gitr${SRCPV}"
PR = "r0"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/utilities.git;protocol=git;branch=master \
"
S = "${WORKDIR}/git/android/rpc"

inherit autotools
