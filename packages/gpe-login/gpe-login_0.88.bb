DESCRIPTION = "GPE user login screen"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget gpe-ownerinfo xkbd"
RDEPENDS = "xkbd"
RPROVIDES = "gpe-session-starter"
PR = "r1"

inherit gpe

SRC_URI += "file://removeblue-fontsize8.patch;patch=1"
SRC_URI += " file://chvt-keylaunch.patch;patch=1 "
SRC_URI += " file://use-xtscal.patch;patch=1 "

