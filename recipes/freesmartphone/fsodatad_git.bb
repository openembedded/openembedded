require cornucopia.inc
inherit fso-plugin
PR = "${INC_PR}.1"
PV = "0.1.0+gitr${SRCREV}"

DEPENDS += "libxml2"
RDEPENDS += "mobile-broadband-provider-info"
