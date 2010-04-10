
inherit gpe

PR          = "r0"
LICENSE     = "GPL"
DESCRIPTION = "GPE file manager"
DEPENDS     = "libgpewidget gnome-vfs dbus-glib"
SECTION = "gpe"
RDEPENDS    = "gpe-icons"
RRECOMMENDS = "gnome-vfs-plugin-file"

FILES_${PN} += " ${datadir}/gpe"

SRC_URI[md5sum] = "2ddfe35b6bcf3269de704bfb44b568e1"
SRC_URI[sha256sum] = "434991a5c562ebb1e381e05dddc6c8916f5a8c851dc4d2a6b3781db1222a8f69"
