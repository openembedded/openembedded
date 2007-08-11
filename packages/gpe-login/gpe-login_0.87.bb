LICENSE = "GPL"
inherit gpe

DESCRIPTION = "GPE user login screen"
SECTION = "gpe"
PRIORITY    = "optional"
DEPENDS     = "gtk+ libgpewidget gpe-ownerinfo xkbd"
RDEPENDS    = "xkbd"
RPROVIDES_${PN}   = "gpe-session-starter"
PR = "r3"

SRC_URI_OVERRIDES_PACKAGE_ARCH = "1"

SRC_URI += "file://removeblue-fontsize8.patch;patch=1"

SRC_URI += " file://chvt-keylaunch.patch;patch=1 "
