
inherit gpe

PR          = "r0"
LICENSE     = "GPL"
DESCRIPTION = "GPE file manager"
DEPENDS     = "libgpewidget gnome-vfs dbus-glib"
SECTION = "gpe"
RDEPENDS    = "gpe-icons"
RRECOMMENDS = "gnome-vfs-plugin-file"

FILES_${PN} += " ${datadir}/gpe"

SRC_URI[md5sum] = "8590fa6cee86c3ae66c449470da62b20"
SRC_URI[sha256sum] = "172e19d8ccaec35329064184790f9e4e64f1b31f412ba8b12c21860208a4e35e"
