require cornucopia.inc
inherit fso-plugin
PV = "0.9.0.1+gitr${SRCREV}"
PR = "${INC_PR}.2"

SRC_URI += "file://fsousaged.conf"

do_install_append() {
	install -d ${D}${sysconfdir}/freesmartphone/
	install -m 0644 ${WORKDIR}/fsousaged.conf ${D}${sysconfdir}/freesmartphone/
}

FILES_${PN} += "${sysconfdir}/freesmartphone/fsousaged.conf"
CONFFILES_${PN} += "${sysconfdir}/freesmartphone/fsousaged.conf"
