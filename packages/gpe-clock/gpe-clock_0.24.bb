inherit gpe

DESCRIPTION = "GPE panel clock"
DEPENDS = "gtk+ libschedule libgpewidget gpe-announce atd libgpelaunch"
RDEPENDS = "gpe-announce atd"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r1"

SRC_URI += "file://name-fix.patch;patch=1"
