require cornucopia.inc
inherit fso-plugin
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PE = "1"
PR = "${INC_PR}.0"
PV = "0.2.0+gitr${SRCPV}"
S = "${WORKDIR}/git/tools/${PN}"
