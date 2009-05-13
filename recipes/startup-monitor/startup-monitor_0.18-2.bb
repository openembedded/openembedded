DESCRIPTION = "Startup notification support"
LICENSE = "GPL"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 startup-notification glib-2.0 libmatchbox"
PR = "r1"

inherit gpe pkgconfig

#SRC_URI = "http://www.freedesktop.org/software/startup-notification/releases/${P}.tar.gz"

SRC_URI += "file://makefile-fix.patch;patch=1"
