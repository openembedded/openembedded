require cornucopia.inc
inherit fso-plugin
PR = "${INC_PR}.0"
PV = "0.1.0+gitr${SRCREV}"

DEPENDS += "libxml2 mobile-broadband-provider-info"
