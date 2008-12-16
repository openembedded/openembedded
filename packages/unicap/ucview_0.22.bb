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
