DESCRIPTION = "GPE panel clock"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libschedule libgpewidget gpe-announce libgpelaunch"
RDEPENDS = "gpe-announce atd"

INC_PR = "r2"

inherit gpe
