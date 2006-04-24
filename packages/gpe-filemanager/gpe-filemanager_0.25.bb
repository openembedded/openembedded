
inherit gpe

PR          = "r1"
LICENSE     = "GPL"
DESCRIPTION = "GPE file manager"
DEPENDS     = "libgpewidget gnome-vfs dbus"
SECTION     = "gpe"
RDEPENDS    = "gpe-icons"
RRECOMMENDS = "gnome-vfs-plugin-file gnome-vfs-plugin-smb gnome-vfs-plugin-ftp gnome-vfs-plugin-computer gnome-vfs-plugin-network gnome-vfs-plugin-sftp gnome-vfs-plugin-http"

FILES_${PN} += " ${datadir}/gpe"
