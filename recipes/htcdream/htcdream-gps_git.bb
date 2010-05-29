DESCRIPTION = "HTC Dream GPS utility"
SECTION = "console/utils"
LICENSE = "GPL"
SRCREV = "c0e7ca9cce89088192ade34457d9fbf41352c9bf"
#SRCREV = "${AUTOREV}"
PV = "1.0+gitr${SRCPV}"
PR = "r0"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/utilities.git;protocol=git;branch=master \
"
S = "${WORKDIR}/git/android/rpc"

inherit autotools
