require msmcomm.inc

PR = "${INC_PR}.1"
PV = "0.6.0+gitr${SRCPV}"

S = "${WORKDIR}/git/libmsmcomm"

DEPENDS = " \
  vala-native \
  glib-2.0 \
  libgee \
  libfsobasics \
"

inherit autotools vala
