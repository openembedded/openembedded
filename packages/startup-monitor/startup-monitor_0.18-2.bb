DESCRIPTION = "Startup notification support"
LICENSE = "GPL"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"
DEPENDS = "x11 startup-notification glib-2.0 libmatchbox"

inherit gpe pkgconfig 

#SRC_URI = "http://www.freedesktop.org/software/startup-notification/releases/${P}.tar.gz"
