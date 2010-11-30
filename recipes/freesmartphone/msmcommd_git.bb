require msmcomm.inc

PR = "${INC_PR}.1"
PV = "0.5.0+gitr${SRCPV}"

DEPENDS = " \
 vala-native \
 glib-2.0 \
 dbus \
 dbus-glib \
 libfso-glib \
 libfsotransport \
 libgee \
 libmsmcomm \
 msmcommd-specs \
"

S = "${WORKDIR}/git/msmcommd"

inherit autotools vala

FILES_${PN} += "\
  ${sysconfdir} \
  ${datadir}/dbus-1 \
"

