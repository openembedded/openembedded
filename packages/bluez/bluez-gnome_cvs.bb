DESCRIPTION = "Bluetooth configuration applet"
LICENSE = "GPL+LGPL"

DEFAULT_PREFERENCE = "-1"

DEPENDS = "dbus-glib gconf libnotify gtk+"

SRC_URI = "cvs://anonymous@cvs.bluez.org/cvsroot/bluez;module=gnome \
          "
 
PV = "0.13+cvs${SRCDATE}"
S = "${WORKDIR}/gnome"

inherit autotools pkgconfig gconf

FILES_${PN} += "${datadir}/gconf"

