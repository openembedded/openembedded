DESCRIPTION = "Bluetooth configuration applet"
LICENSE = "GPL+LGPL"

PR = "r1"

DEPENDS = "dbus-glib gconf libnotify gtk+"
RRECOMMENDS = "gnome-icon-theme"

SRC_URI = "http://bluez.sourceforge.net/download/${P}.tar.gz"

inherit autotools pkgconfig gconf

FILES_${PN} += "${datadir}/gconf"

