DESCRIPTION = "Bluetooth configuration applet"
LICENSE = "GPL+LGPL"

DEFAULT_PREFERENCE = "-2"

DEPENDS = "dbus-glib gconf libnotify gtk+"

SRC_URI = "git://people.freedesktop.org/~hadess/bluez-gnome;protocol=git \
           file://pkgconfig-add-gthread.patch;patch=1 "

PV = "0.10+git${SRCDATE}"
S = "${WORKDIR}/git"

inherit autotools pkgconfig gconf

FILES_${PN} += "${datadir}/gconf"

