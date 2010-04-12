inherit gpe
LICENSE = "PD"

DESCRIPTION = "A simple light puzzle."
DEPENDS = "gtk+ libgpewidget gpe-icons"
SECTION = "gpe/games"
PRIORITY = "optional"
PR = "r1"

SRC_URI += "file://fix-makefiles.patch;patch=1"

SRC_URI[md5sum] = "fa4677ecb8640c5d85c421dcaebf64fb"
SRC_URI[sha256sum] = "e9de4a153ee3adc66363a583cd7db6676e92f010d783e517ef935aa35e96370e"
