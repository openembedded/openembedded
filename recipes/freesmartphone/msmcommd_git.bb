require msmcomm.inc

PR = "${INC_PR}.2"
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

SRC_URI += "file://msmcommd"

S = "${WORKDIR}/git/msmcommd"

inherit autotools vala update-rc.d

INITSCRIPT_NAME = "msmcommd"
INITSCRIPT_PARAMS = "defaults 28"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/msmcommd ${D}${sysconfdir}/init.d/
}

FILES_${PN} += "\
  ${sysconfdir} \
  ${datadir}/dbus-1 \
"

