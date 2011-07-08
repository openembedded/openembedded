require msmcomm.inc

PR = "${INC_PR}.1"
PV = "0.1.0+gitr${SRCPV}"

S = "${WORKDIR}/git/libmsmhll"

DEPENDS = " \
  vala-native \
  glib-2.0 \
  libgee \
"

inherit autotools vala
