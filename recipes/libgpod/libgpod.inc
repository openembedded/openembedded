DESCRIPTION = "libgpod - a library to access the Apple iPod"
HOMEPAGE = "http://www.gtkpod.org/libgpod.html"
LICENSE = "LGPL"
DEPENDS = "glib-2.0"
SECTION = "libs/multimedia"

inherit autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/gtkpod/libgpod-${PV}.tar.gz;name=archive"

