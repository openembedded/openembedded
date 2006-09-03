inherit gpe

DESCRIPTION = "An Othello clone using GTK, hacked from ugothello."
DEPENDS = "gtk+ libgpewidget gpe-icons"
SECTION = "gpe/games"
PRIORITY = "optional"
PR = "r1"

SRC_URI += "file://fix-makefiles.patch;patch=1"
