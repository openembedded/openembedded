DESCRIPTION = "Bluetooth configuration applet"
LICENSE = "GPL+LGPL"

DEPENDS = "dbus-glib gconf libnotify gtk+"

SRC_URI = "http://bluez.sourceforge.net/download/${P}.tar.gz"

inherit autotools pkgconfig gconf

FILES_${PN} += "${datadir}/gconf"

