LICENSE = "GPL"
inherit gpe

DESCRIPTION = "GPE user login screen"
SECTION     = "gpe"
PRIORITY    = "optional"
DEPENDS     = "gtk+ libgpewidget gpe-ownerinfo xkbd"
RDEPENDS    = "xkbd"
RPROVIDES   = "gpe-session-starter"
PR = "r1"

#apply a patch to set the fontsize for bigdpi (200+) devices to 5
SRC_URI_append_ipaq-pxa270 = " file://highdpifontfix.patch;patch=1"
SRC_URI_append_spitz = " file://highdpifontfix.patch;patch=1"
SRC_URI_append_akita = " file://highdpifontfix.patch;patch=1"
SRC_URI_append_c7x0 = " file://highdpifontfix.patch;patch=1"
SRC_URI_append_nokia770 = " file://highdpifontfix.patch;patch=1"

SRC_URI_append += " file://chvt-keylaunch.patch;patch=1 "
