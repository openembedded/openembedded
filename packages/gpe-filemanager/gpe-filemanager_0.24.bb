
inherit gpe

PR          = "r0"
LICENSE     = "GPL"
DESCRIPTION = "GPE file manager"
DEPENDS     = "libgpewidget gnome-vfs dbus"
SECTION     = "gpe"
RDEPENDS    = "gpe-icons"
RRECOMMENDS = "gnome-vfs-plugin-file"

FILES_${PN} += " ${datadir}/gpe"
