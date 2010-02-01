require cornucopia.inc
inherit fso-plugin
PR = "${INC_PR}.2"
PV = "0.0.0+gitr${SRCREV}"

DEPENDS += "libfsotransport libfsoresource"
