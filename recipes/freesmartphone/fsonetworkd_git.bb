require cornucopia.inc
inherit fso-plugin
PV = "0.1.0.0+gitr${SRCREV}"
PR = "${INC_PR}.2"

SRC_URI += "file://fsonetworkd.conf"

do_install_append() {
	install -d ${D}${sysconfdir}/freesmartphone/
	install -m 0644 ${WORKDIR}/fsonetworkd.conf ${D}${sysconfdir}/freesmartphone/
}

FILES_${PN} += "${sysconfdir}/freesmartphone/fsonetworkd.conf"
CONFFILES_${PN} += "${sysconfdir}/freesmartphone/fsonetworkd.conf"
