LICENSE = "GPL"
inherit gpe

DESCRIPTION = "GPE user login screen"
SECTION     = "gpe"
PRIORITY    = "optional"
DEPENDS     = "gtk+ libgpewidget gpe-ownerinfo xkbd"
RDEPENDS    = "xkbd"
RPROVIDES   = "gpe-session-starter"
PR = "r1"

SRC_URI += "file://removeblue-fontsize8.patch;patch=1"

SRC_URI += " file://chvt-keylaunch.patch;patch=1 "
