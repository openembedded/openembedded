DESCRIPTION = "Vino is an integrated VNC server for GNOME."
LICENSE = "GPLv2"

DEPENDS = "libgnomeui libglade gnome-keyring esound dbus-glib libxml2 gnutls gnome-vfs"

inherit gnome gconf



SRC_URI[archive.md5sum] = "be507a80ec2c3cd5888060b81ff74f4e"
SRC_URI[archive.sha256sum] = "f01b24635120e9f5fc5332cbdff49e26603d1c7089d70057209f41cd634751e7"
