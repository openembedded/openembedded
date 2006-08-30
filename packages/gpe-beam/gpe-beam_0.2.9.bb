DESCRIPTION = "GPE infrared communication applet"
DEPENDS = "gtk+ libgpewidget libmimedir libgpevtype openobex irda-utils dbus-glib"
RDEPENDS = "irda-utils"
SECTION = "gpe"
PRIORITY = "optional"
MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"
LICENSE = "GPL"

inherit gpe

