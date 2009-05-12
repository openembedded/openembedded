DESCRIPTION = "GPE panel clock"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libschedule libgpewidget gpe-announce atd libgpelaunch"
RDEPENDS = "gpe-announce"

inherit gpe

SRC_URI += "file://fix-install.patch;patch=1"
