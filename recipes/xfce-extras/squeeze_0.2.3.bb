DESCRIPTION = "Squeeze is an archive manager for the Xfce Desktop  Environment"
DEPENDS = "pkgconfig dbus gtk+ thunar"
RDEPENDS = "libxfce4util"

SECTION = "x11"
PR = "r1"

inherit xfce46

XFCE_VERSION = "4.6.1"

SRC_URI = "http://squeeze.xfce.org/downloads/${PN}-${PV}.tar.bz2"

SRC_URI[md5sum] = "bd3cb0648b49be1f146fc4f675606176"
SRC_URI[sha256sum] = "7b8dc13e0adf72c67bba12e1ed1285ec820946e65d0eec247f7bd159a2cfac2d"
