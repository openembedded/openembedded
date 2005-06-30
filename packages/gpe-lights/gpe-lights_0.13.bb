inherit gpe
LICENSE = "PD"

DESCRIPTION = "A simple light puzzle."
DEPENDS = "gtk+ libgpewidget gpe-icons"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += "file://fix-makefiles.patch;patch=1"
