DESCRIPTION = "obex plugin for gnome-vfs"
LICENSE = "GPLv2"
DEPENDS = "openobex gnome-vfs bluez-utils"

PR = "r1"

inherit gnome

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/gnome-vfs-obexftp/${PV}/${PN}-${PV}.tar.bz2"

FILES_${PN}-dbg += "${libdir}/gnome-vfs-2.0/modules/.debug"
FILES_${PN} += "${libdir}/gnome-vfs-2.0/modules/*.so"

