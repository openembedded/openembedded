PR = "r0"

inherit gpe

DESCRIPTION = "GPE infrared communication applet"
DEPENDS = "gtk+ libgpewidget libmimedir libgpevtype openobex irda-utils dbus-glib"
RDEPENDS = "irda-utils"
SECTION = "gpe"
PRIORITY = "optional"
MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"
LICENSE = "GPL"

SRC_URI += "file://dbus-new-api.patch;patch=1"
