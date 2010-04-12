DESCRIPTION = "Bluetooth configuration applet"
LICENSE = "GPL+LGPL"

DEFAULT_PREFERENCE = "-2"

DEPENDS = "dbus-glib gconf libnotify gtk+"

SRCREV = "c4ccbf7c4d0aa55e234d30e6daee494e496c7c7f"
SRC_URI = "git://git.kernel.org/pub/scm/bluetooth/bluez-gnome.git;protocol=git;branch=master "
#           file://pkgconfig-add-gthread.patch;patch=1 "

PV = "0.10+gitr${SRCREV}"
S = "${WORKDIR}/git"

inherit autotools pkgconfig gconf

FILES_${PN} += "${datadir}/gconf"

