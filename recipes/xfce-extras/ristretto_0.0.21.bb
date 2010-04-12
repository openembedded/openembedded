DESCRIPTION = "Ristretto is a picture-viewer for XFCE"
DEPENDS = "thunar libxfce4util libxfcegui4 libexif dbus"
RDEPENDS = "thunar libxfce4util libxfcegui4"

SECTION = "x11"
PR = "r1"

inherit xfce46

XFCE_VERSION = "4.6.1"

SRC_URI = "http://goodies.xfce.org/releases/ristretto/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "7774dcafdc365e70b8d981c0a52d6250"
SRC_URI[sha256sum] = "b3e63ef1d4a582c2a3f4e99f097ec28273edf9feb51162b470d4c12c61a51378"
