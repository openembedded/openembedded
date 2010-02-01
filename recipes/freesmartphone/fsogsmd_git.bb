require cornucopia.inc
inherit fso-plugin
PR = "${INC_PR}.2"
PV = "0.2.0+gitr${SRCREV}"

DEPENDS += "libfsoresource libgsm0710mux"

do_install_append_shr() {
	# remove .service file to disable fsogsmd autostart
	rm -f ${D}${datadir}/dbus-1/system-services/org.freesmartphone.ogsmd.service
}
