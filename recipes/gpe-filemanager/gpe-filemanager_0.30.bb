
GPE_TARBALL_SUFFIX = "bz2"
inherit autotools gpe

PR          = "r0"
LICENSE     = "GPL"
DESCRIPTION = "GPE file manager"
DEPENDS     = "libgpewidget gnome-vfs dbus-glib"
SECTION = "gpe"
RDEPENDS    = "gpe-icons"
RRECOMMENDS = "gnome-vfs-plugin-file gnome-vfs-plugin-smb gnome-vfs-plugin-ftp gnome-vfs-plugin-computer gnome-vfs-plugin-network gnome-vfs-plugin-sftp gnome-vfs-plugin-http"

FILES_${PN} += " ${datadir}/gpe"

SRC_URI[md5sum] = "aecfb8d03fbfe11dfe6bc17db9591aee"
SRC_URI[sha256sum] = "6b4b4ee697472c7073e3ef9fa2e2ff89bcee07be452942814857cad3ef4f55ff"
