DESCRIPTION = "Startup notification support"
LICENSE = "GPL"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 startup-notification glib-2.0 libmatchbox"
PR = "r1"

inherit gpe pkgconfig

#SRC_URI = "http://www.freedesktop.org/software/startup-notification/releases/${P}.tar.gz"

SRC_URI += "file://makefile-fix.patch;patch=1"

SRC_URI[md5sum] = "2ac92d4deda518558036a5685fc28814"
SRC_URI[sha256sum] = "0d1570843bd479ad6183f5014c3da3f68915f9c2626f11d96b422852a9991d86"
