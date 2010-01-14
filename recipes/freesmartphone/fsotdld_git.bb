require cornucopia.inc
inherit fso-plugin
PR = "${INC_PR}.2"
PV = "0.0.0+gitr${SRCREV}"

DEPENDS += "libfsotransport libfsoresource"

SRC_URI += "file://fsotdld.conf"

do_install_append() {
	install -d ${D}${sysconfdir}/freesmartphone/
	install -m 0644 ${WORKDIR}/fsotdld.conf ${D}${sysconfdir}/freesmartphone/
}

FILES_${PN} += "${sysconfdir}/freesmartphone/fsotdld.conf"
CONFFILES_${PN} += "${sysconfdir}/freesmartphone/fsotdld.conf"
