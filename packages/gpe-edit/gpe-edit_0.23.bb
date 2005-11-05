LICENSE = "GPL"
PR = "r1"

inherit gpe

DEPENDS = "gtk+ libdisplaymigration libgpewidget"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SECTION = "gpe"
DESCRIPTION = "Editor for the GPE Palmtop Environment"

SRC_URI = "${GPE_MIRROR}/gpe-edit-${PV}.tar.gz \
	file://desktop-categories.patch;patch=1"

