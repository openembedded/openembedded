inherit gpe
LICENSE = "GPL"
DESCRIPTION = "GPE file manager"
DEPENDS = "libgpewidget gnome-vfs dbus sqlite"
SECTION = "gpe"
RDEPENDS = "gpe-icons"
RRECOMMENDS = "gnome-vfs-plugin-file"
PR = "r2"

FILES_${PN} += " ${datadir}/gpe"
