LICENSE = "GPL"
inherit gpe

DESCRIPTION = "GPE to-do list"
DEPENDS = "gtk+ libdisplaymigration libgpewidget libgpepimc libtododb"
SECTION = "gpe"
PRIORITY = "optional"
PR ="r1"

SRC_URI += "file://remove-render.patch;patch=1"

