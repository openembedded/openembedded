LICENSE = "GPL"
SECTION = "x11/gnome"
PR = "r1"

inherit gnome

DEPENDS += "gnome-vfs samba"

FILES_${PN} += "${datadir}/gnome ${libdir}/gnome-vfs-2.0/modules/*.so"
FILES_${PN}-dev += "${libdir}/gnome-vfs-2.0/modules/*"

SRC_URI[archive.md5sum] = "29f6997c0523254b54f8d36f0361b824"
SRC_URI[archive.sha256sum] = "482bda65d8083a66f84d88d808388fac34b2c5d808676105d200ac9049efb82e"
