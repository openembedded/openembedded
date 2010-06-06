DESCRIPTION = "GNOME bluetooth manager"
LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = "gnome-doc-utils-native obexd obex-data-server gconf gtk+ dbus-glib libunique libnotify hal bluez4 gnome-keyring"

PR = "r1"

inherit gnome

SRC_URI[archive.md5sum] = "eb88212922037eb9751f0fcedb9c166e"
SRC_URI[archive.sha256sum] = "4caafa8c28195c81d8c51414f3a64489f81b9b46cac56979aeaaff8c9ebb78d4"

# No 'nautilus-sendto' recipe in OE et
EXTRA_OECONF = "--enable-nautilus-sendto=no"

do_configure_append() {
	sed -i 's,func_fatal_error "error: cannot install,echo "bogus message about,' ${TARGET_PREFIX}libtool
}

RRECOMMENDS_${PN} += "obexd obex-data-server"
RCONFLICTS_${PN} = "bluez-gnome"

FILES_${PN}-dbg += "${libdir}/gnome-bluetooth/plugins/.debug/"

