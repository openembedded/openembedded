require connman.inc
PV = "0.22+gitr${SRCPV}"
PR = "r1"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "\
  git://git.kernel.org/pub/scm/network/connman/connman.git;protocol=git \
  file://connman.dbus \
  file://connman \
"
S = "${WORKDIR}/git"
