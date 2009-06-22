require connman.inc
PV = "0.19+gitr${SRCREV}"
PR = "r0"

#DEFAULT_PREFERENCE = "-1"

SRC_URI = "\
  git://git.kernel.org/pub/scm/network/connman/connman.git;protocol=git \
  file://connman.dbus \
  file://connman \
"
S = "${WORKDIR}/git"
