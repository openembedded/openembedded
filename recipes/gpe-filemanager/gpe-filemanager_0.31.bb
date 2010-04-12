
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

SRC_URI[md5sum] = "2edb97e768f380da0b5c4e993ceb129b"
SRC_URI[sha256sum] = "3d117a3c9174d07a6d5dd5bb63d3841bf185e90732e8426678d7928c0c27f623"
