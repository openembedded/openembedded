DESCRIPTION = "GPE user login screen"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget gpe-ownerinfo xkbd"
RDEPENDS = "xkbd"
RPROVIDES_${PN} = "gpe-session-starter"
PR = "r3"

SRC_URI_OVERRIDES_PACKAGE_ARCH = "1"

inherit gpe


SRC_URI += "file://removeblue-fontsize8.patch;patch=1"
SRC_URI += " file://chvt-keylaunch.patch;patch=1 "
SRC_URI += " file://use-xtscal.patch;patch=1 "

SRC_URI_append_spitz = "file://brightness-adjust-keyluanchrc.patch;patch=1"
SRC_URI_append_akita = "file://brightness-adjust-keyluanchrc.patch;patch=1"
SRC_URI_append_c7x0 = "file://brightness-adjust-keyluanchrc.patch;patch=1"

