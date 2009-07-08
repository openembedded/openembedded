require cornucopia.inc
inherit fso-plugin

DEPENDS += "alsa-lib"
RDEPENDS += "libcanberra-alsa"
RRECOMMENDS += "fso-alsa-data"
PR = "${INC_PR}.4"
