DESCRIPTION = "Bluetooth configuration applet"
LICENSE = "GPL+LGPL"
PR = "r1"

DEPENDS = "dbus-glib gconf libnotify gtk+"
RRECOMMENDS = "gnome-icon-theme"

SRC_URI = "http://www.kernel.org/pub/linux/bluetooth/${P}.tar.gz \
	   file://add-device-from-rfcomm-crash.patch;patch=1 \
	   file://cs-typo.patch;patch=1"

inherit autotools pkgconfig gconf mime

FILES_${PN} += "${datadir}/gconf ${datadir}/icons ${datadir}/mime/packages"
