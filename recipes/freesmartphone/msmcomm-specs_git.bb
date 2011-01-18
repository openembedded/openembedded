require msmcomm.inc

PR = "${INC_PR}.1"
PV = "0.6.0+gitr${SRCPV}"
PE = "1"

DEPENDS = " \
 vala-native \
 glib-2.0 \
"

S = "${WORKDIR}/git/msmcomm-specs"

inherit autotools vala

