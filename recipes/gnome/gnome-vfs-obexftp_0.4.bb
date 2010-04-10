DESCRIPTION = "obex plugin for gnome-vfs"
LICENSE = "GPLv2"
DEPENDS = "openobex gnome-vfs bluez-utils"

PR = "r1"

inherit gnome

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/gnome-vfs-obexftp/${PV}/${PN}-${PV}.tar.bz2"

FILES_${PN}-dbg += "${libdir}/gnome-vfs-2.0/modules/.debug"
FILES_${PN} += "${libdir}/gnome-vfs-2.0/modules/*.so"


SRC_URI[md5sum] = "6e38828738301fb3ec88c0461ff53a60"
SRC_URI[sha256sum] = "2a50b2bb76c521f588e14ee2ed5411f5abad750050d929dcea32ebd0de3499f8"
