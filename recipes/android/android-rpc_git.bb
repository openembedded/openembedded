DESCRIPTION = "Android RPC library"
SECTION = "devel"
LICENSE = "GPL"
SRCREV = "72b90c4185c3a14657e3d05dba4ed44acdf6bce6"
PV = "1.0+gitr${SRCPV}"
PR = "r0"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/utilities.git;protocol=git;branch=master \
"
S = "${WORKDIR}/git/android/rpc"

inherit autotools
