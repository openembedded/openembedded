require cornucopia.inc
inherit fso-plugin

DEPENDS += "alsa-lib libcanberra"
RDEPENDS += "libcanberra-alsa"
RRECOMMENDS += "fso-alsa-data"
PV = "0.9.0+gitr${SRCREV}"
PR = "${INC_PR}.0"
