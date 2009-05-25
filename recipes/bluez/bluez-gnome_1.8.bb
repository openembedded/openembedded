DESCRIPTION = "Bluetooth configuration applet"
LICENSE = "GPL+LGPL"

DEPENDS = "dbus-glib gconf libnotify gtk+"
RRECOMMENDS = "gnome-icon-theme"

SRC_URI = "http://www.kernel.org/pub/linux/bluetooth/${P}.tar.gz"

inherit autotools pkgconfig gconf mime

FILES_${PN} += "${datadir}/gconf ${datadir}/icons ${datadir}/mime/packages"
