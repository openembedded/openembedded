inherit gpe

DESCRIPTION = "GPE panel clock"
DEPENDS = "gtk+ libschedule libgpewidget gpe-announce atd"
RDEPENDS = "gpe-announce atd"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz \
	   file://default-time-24hrs.patch;patch=1"
