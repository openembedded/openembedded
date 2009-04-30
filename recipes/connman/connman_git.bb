require connman.inc
PV = "0.12+gitr${SRCPV}"
PR = "r0"
PE = "1"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "\
  git://git.kernel.org/pub/scm/network/connman/connman.git;protocol=git \
  file://connman \
"
S = "${WORKDIR}/git"
