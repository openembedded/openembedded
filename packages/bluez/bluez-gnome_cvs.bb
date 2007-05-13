DESCRIPTION = "BLuetooth configuration applet"
LICENSE = "GPL+LGPL"

DEPENDS = "bluez-libs dbus-glib gconf libnotify gtk+ openobex"

SRC_URI = "cvs://anonymous@cvs.bluez.org/cvsroot/bluez;module=gnome"

PV = "0.6+cvs${SRCDATE}"
S = "${WORKDIR}/gnome"

inherit autotools pkgconfig gconf

FILES_${PN} += "${datadir}/gconf"

