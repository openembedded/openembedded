DESCRIPTION = "Android RPC library"
SECTION = "devel"
LICENSE = "GPL"
SRCREV = "9da90ad4ebc0efe978c61060d8fdf7362cc9115c"
PV = "1.1+gitr${SRCPV}"
PR = "r0"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/utilities.git;protocol=git;branch=master \
"
S = "${WORKDIR}/git/android/rpc"

inherit autotools
