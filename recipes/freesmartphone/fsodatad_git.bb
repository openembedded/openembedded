require cornucopia.inc
inherit fso-plugin
PR = "${INC_PR}.2"
PV = "0.0.0+gitr${SRCREV}"

DEPENDS += "libxml2 mobile-broadband-provider-info"

SRC_URI += "file://fsodatad.conf"

do_install_append() {
	install -d ${D}${sysconfdir}/freesmartphone/
	install -m 0644 ${WORKDIR}/fsodatad.conf ${D}${sysconfdir}/freesmartphone/
}

FILES_${PN} += "${sysconfdir}/freesmartphone/fsodatad.conf"
CONFFILES_${PN} += "${sysconfdir}/freesmartphone/fsodatad.conf"
