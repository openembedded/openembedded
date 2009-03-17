inherit gpe
LICENSE = "PD"

DESCRIPTION = "A simple light puzzle."
DEPENDS = "gtk+ libgpewidget gpe-icons"
SECTION = "gpe/games"
PRIORITY = "optional"
PR = "r1"

SRC_URI += "file://fix-makefiles.patch;patch=1"
