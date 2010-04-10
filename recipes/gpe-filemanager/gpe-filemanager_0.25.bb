
inherit gpe

PR          = "r1"
LICENSE     = "GPL"
DESCRIPTION = "GPE file manager"
DEPENDS     = "libgpewidget gnome-vfs dbus-glib"
SECTION = "gpe"
RDEPENDS    = "gpe-icons"
RRECOMMENDS = "gnome-vfs-plugin-file gnome-vfs-plugin-smb gnome-vfs-plugin-ftp gnome-vfs-plugin-computer gnome-vfs-plugin-network gnome-vfs-plugin-sftp gnome-vfs-plugin-http"

FILES_${PN} += " ${datadir}/gpe"

SRC_URI[md5sum] = "625cb4e7a316c3a17f5cedca90dc3cb7"
SRC_URI[sha256sum] = "debebb0d6572ebaeabcd7581d688f69e20024f25be5fde01e6d0d8aaa149ebb3"
