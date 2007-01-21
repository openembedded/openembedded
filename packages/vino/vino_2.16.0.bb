DESCRIPTION = "Vino is an integrated VNC server for GNOME."
LICENSE = "GPLv2"

DEPENDS = "libgnomeui libglade gnome-keyring esound dbus-glib libxml2 gnutls gnome-vfs"

inherit gnome gconf

do_configure() {
	libtoolize --force
	gnu-configize
	oe_runconf
}

