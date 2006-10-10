PR = "r0"

inherit gpe

DESCRIPTION = "GPE infrared communication applet"
DEPENDS = "gtk+ libgpewidget libmimedir libgpevtype openobex irda-utils dbus-glib"
RDEPENDS = "irda-utils"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI += "file://dbus-new-api.patch;patch=1"
