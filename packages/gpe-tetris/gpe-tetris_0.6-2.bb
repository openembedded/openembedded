LICENSE = GPL
inherit gpe

DESCRIPTION = "GTK+2 port of the well known game, Tetris."
DEPENDS = "gtk+ libgpewidget gpe-icons"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += "file://fix-makefiles.patch;patch=1"
