DESCRIPTION = "Ristretto is a picture-viewer for XFCE"
DEPENDS = "thunar libxfce4util libxfcegui4 libexif dbus"
RDEPENDS = "thunar libxfce4util libxfcegui4"

SECTION = "x11"
PR = "r1"

inherit xfce46

XFCE_VERSION = "4.6.1"

SRC_URI = "http://goodies.xfce.org/releases/ristretto/${PN}-${PV}.tar.gz"
