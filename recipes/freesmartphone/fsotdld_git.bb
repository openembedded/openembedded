require cornucopia.inc
inherit fso-plugin
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PR = "${INC_PR}.4"
PV = "0.3.1+gitr${SRCPV}"
PE = "1"

DEPENDS += "libfsotransport libfsoresource json-glib libsoup-2.4"

inherit update-rc.d

INITSCRIPT_NAME = "fsotdld"
INITSCRIPT_PARAMS = "defaults 27"

SRC_URI += "file://fsotdld"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/fsotdld ${D}${sysconfdir}/init.d/
}

