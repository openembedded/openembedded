inherit gpe

DESCRIPTION = "GPE panel clock"
DEPENDS = "gtk+ libschedule libgpewidget gpe-announce atd libgpelaunch"
RDEPENDS = "gpe-announce atd"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI += "file://default-time-24hrs.patch;patch=1"
