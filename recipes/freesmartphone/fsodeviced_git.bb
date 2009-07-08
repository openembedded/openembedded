require cornucopia.inc
inherit fso-plugin

DEPENDS += "alsa-lib"
RDEPENDS += "libcanberra-alsa"
PR = "${INC_PR}.3"
