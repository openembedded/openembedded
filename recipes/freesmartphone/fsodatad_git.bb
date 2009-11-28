require cornucopia.inc
inherit fso-plugin
PR = "${INC_PR}.0"
PV = "0.0.0+gitr${SRCPV}"

DEPENDS += "libxml2 mobile-broadband-provider-info"
