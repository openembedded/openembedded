DESCRIPTION = "Startup notification support"
LICENSE = "GPL"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 startup-notification glib-2.0 libmatchbox"

inherit gpe pkgconfig

#SRC_URI = "http://www.freedesktop.org/software/startup-notification/releases/${P}.tar.gz"
