PR = "r1"

inherit gpe

DESCRIPTION = "GPE infrared communication applet"
DEPENDS = "gtk+ libgpewidget libmimedir libgpevtype openobex irda-utils dbus"
RDEPENDS = "libopenobex-1.0-1 irda-utils"
SECTION = "gpe"
PRIORITY = "optional"
MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"
LICENSE = "GPL"

SRC_URI += "file://decl.patch;patch=1;pnum=0"