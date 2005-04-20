LICENSE = "GPL"
inherit gpe

DESCRIPTION = "GPE to-do list"
DEPENDS = "gtk+ libdisplaymigration libgpewidget libgpepimc libtododb"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SECTION = "gpe"
PRIORITY = "optional"
PR="r1"

SRC_URI += "file://remove-render.patch;patch=1"

