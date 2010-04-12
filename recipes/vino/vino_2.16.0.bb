DESCRIPTION = "Vino is an integrated VNC server for GNOME."
LICENSE = "GPLv2"

DEPENDS = "libgnomeui libglade gnome-keyring esound dbus-glib libxml2 gnutls gnome-vfs"

inherit gnome gconf

do_configure() {
	libtoolize --force
	gnu-configize
	oe_runconf
}


SRC_URI[archive.md5sum] = "89937e6d6cd8f658d037da0a7cfd3f4e"
SRC_URI[archive.sha256sum] = "bcf62f1121fe704a019363467f9182e29931ee6779f3b65e996171f4caa11369"
