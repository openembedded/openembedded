require cornucopia.inc
inherit fso-plugin

DEPENDS += "alsa-lib libcanberra libfsoresource"
RDEPENDS += "libcanberra-alsa"
RRECOMMENDS += "fso-alsa-data"
PV = "0.9.0+gitr${SRCPV}"
PE = "1"
PR = "${INC_PR}.0"
