inherit gpe
LICENSE = "GPL"
DEPENDS = "libgpewidget sqlite gnome-vfs gnome-vfs-extras dbus"
SECTION = "gpe"
RDEPENDS = "gpe-icons"
DESCRIPTION = "GPE file manager"

FILES_${PN} += " ${datadir}/gpe"
