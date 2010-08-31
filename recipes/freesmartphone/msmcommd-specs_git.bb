require msmcomm.inc

PR = "${INC_PR}.0"
PV = "0.5.0+gitr${SRCPV}"
PE = "1"

DEPENDS = " \
 vala-native \
 glib-2.0 \
 dbus \
 dbus-glib \
"

S = "${WORKDIR}/git/msmcommd-specs"

inherit autotools vala

