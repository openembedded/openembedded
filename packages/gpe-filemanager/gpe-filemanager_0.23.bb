
inherit gpe

PR          = "r1"
LICENSE     = "GPL"
DESCRIPTION = "GPE file manager"
DEPENDS     = "libgpewidget gnome-vfs-dbus dbus"
SECTION     = "gpe"
RDEPENDS    = "gpe-icons"
RRECOMMENDS = "gnome-vfs-plugin-file"

FILES_${PN} += " ${datadir}/gpe"

SRC_URI += " file://dbus-new-api.patch;patch=1"
