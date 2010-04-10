DESCRIPTION = "Simple camera capture GUI based on unicap."
SECTION = "graphics"
LICENSE = "GPL"
DEPENDS = "intltool-native gtk+ libpng unicap gconf libglade gdk-pixbuf-csource-native"
PR = "r1"

SRC_URI = "http://www.unicap-imaging.org/downloads/${P}.tar.gz \
           file://cross.patch;patch=1"

inherit autotools pkgconfig

FILES_${PN} += " ${datadir}/dbus-1 ${datadir}/icons"
FILES_${PN}-dbg += " ${libdir}/ucview/plugins/.debug"

SRC_URI[md5sum] = "509077240e1f8a3d865953c4224182b9"
SRC_URI[sha256sum] = "b3e501f327ca7c762bef56ea786e1d1fcc27b2354e1b98fc4e5c9a078b870873"
