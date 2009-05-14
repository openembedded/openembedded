LICENSE = "GPL"
inherit gpe
PR = "r1"


DESCRIPTION = "GTK+2 port of the well known game, Tetris."
DEPENDS = "gtk+ libgpewidget gpe-icons"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += "file://fix-install.patch;patch=1"
