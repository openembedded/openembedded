LICENSE = "GPL"
SECTION = "x11/gnome"
PR = "r1"

inherit gnome

DEPENDS += "gnome-vfs samba"

FILES_${PN} += "${datadir}/gnome ${libdir}/gnome-vfs-2.0/modules/*.so"
FILES_${PN}-dev += "${libdir}/gnome-vfs-2.0/modules/*"
