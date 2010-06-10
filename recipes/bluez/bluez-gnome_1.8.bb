DESCRIPTION = "Bluetooth configuration applet"
LICENSE = "GPL+LGPL"
PR = "r2"

DEPENDS = "dbus-glib gconf libnotify gtk+"
RRECOMMENDS_${PN} = "gnome-icon-theme"

SRC_URI = "http://www.kernel.org/pub/linux/bluetooth/${P}.tar.gz \
	   file://add-device-from-rfcomm-crash.patch \
	   file://cs-typo.patch"

inherit autotools pkgconfig gconf mime

FILES_${PN} += "${datadir}/gconf ${datadir}/icons ${datadir}/mime/packages"

SRC_URI[md5sum] = "7f34a08e36aa77d4476d0919c52b59b6"
SRC_URI[sha256sum] = "481b48f3cde1f896650195b75c25994df11eca05bb6e8d1951a46b603228811a"
