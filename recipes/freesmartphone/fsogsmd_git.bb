require cornucopia.inc
inherit fso-plugin
PR = "${INC_PR}.0"
PV = "0.2.0+gitr${SRCREV}"

DEPENDS += "libfsoresource libgsm0710mux libxml2 mobile-broadband-provider-info"
