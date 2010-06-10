DESCRIPTION = "GPE panel clock"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libschedule libgpewidget gpe-announce libgpelaunch"
RDEPENDS_${PN} = "gpe-announce atd"

INC_PR = "r3"

inherit gpe
