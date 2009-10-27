DESCRIPTION = "Squeeze is an archive manager for the Xfce Desktop  Environment"
DEPENDS = "pkgconfig dbus gtk+ thunar"
RDEPENDS = "libxfce4util"

SECTION = "x11"
PR = "r1"

inherit xfce46

XFCE_VERSION = "4.6.1"

SRC_URI = "http://squeeze.xfce.org/downloads/${PN}-${PV}.tar.bz2"
