require cornucopia.inc
inherit fso-plugin
PR = "${INC_PR}.0"
PV = "0.2.0+gitr${SRCPV}"
PE = "1"

DEPENDS += "libfsoresource libgsm0710mux"
