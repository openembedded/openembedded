DESCRIPTION = "BLuetooth configuration applet"
LICENSE = "GPL+LGPL"

DEPENDS = "bluez-libs dbus-glib gconf libnotify gtk+ openobex"

SRC_URI = "http://bluez.sourceforge.net/download/${P}.tar.gz"

inherit autotools pkgconfig


