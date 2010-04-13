require cornucopia.inc
inherit fso-plugin
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PR = "${INC_PR}.2"
PV = "0.1.0+gitr${SRCPV}"
PE = "1"

DEPENDS += "\
  libxml2 \
  mobile-broadband-provider-info \
"
RDEPENDS += "mobile-broadband-provider-info"
