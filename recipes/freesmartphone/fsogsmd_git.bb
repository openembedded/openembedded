require cornucopia.inc
inherit fso-plugin
PR = "${INC_PR}.2"
PV = "0.2.0+gitr${SRCREV}"

DEPENDS += "libfsoresource libgsm0710mux"

SRC_URI += "file://fsogsmd.conf"

do_install_append() {
	install -d ${D}${sysconfdir}/freesmartphone/
	install -m 0644 ${WORKDIR}/fsogsmd.conf ${D}${sysconfdir}/freesmartphone/
}

do_install_append_shr() {
	# remove .service file to disable fsogsmd autostart
	rm -f ${D}${datadir}/dbus-1/system-services/org.freesmartphone.ogsmd.service
}

FILES_${PN} += "${sysconfdir}/freesmartphone/fsogsmd.conf"
CONFFILES_${PN} += "${sysconfdir}/freesmartphone/fsogsmd.conf"
