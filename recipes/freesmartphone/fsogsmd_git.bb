require cornucopia.inc
inherit fso-plugin
PR = "${INC_PR}.1"
PV = "0.2.0+gitr${SRCREV}"

DEPENDS += "libfsoresource libgsm0710mux"

SRC_URI += "file://fsogsmd.conf"

do_install_append() {
	install -d ${D}${sysconfdir}/freesmartphone/
	install -m 0644 ${WORKDIR}/fsogsmd.conf ${D}${sysconfdir}/freesmartphone/
}

FILES_${PN} += "${sysconfdir}/freesmartphone/fsogsmd.conf"
