inherit gpe
LICENSE = "GPL"
DESCRIPTION = "GPE file manager"
DEPENDS = "libgpewidget gnome-vfs dbus"
SECTION = "gpe"
RDEPENDS = "gpe-icons"
RRECOMMENDS = "gnome-vfs-plugin-file"
PR = "r1"

FILES_${PN} += " ${datadir}/gpe"
