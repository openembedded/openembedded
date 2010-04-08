DESCRIPTION = "GNOME bluetooth manager"
LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = "obexd obex-data-server gconf gtk+ dbus-glib libunique libnotify hal bluez4 gnome-keyring"

inherit gnome

SRC_URI[archive.md5sum] = "eb88212922037eb9751f0fcedb9c166e"
SRC_URI[archive.sha256sum] = "4caafa8c28195c81d8c51414f3a64489f81b9b46cac56979aeaaff8c9ebb78d4"

# No 'nautilus-sendto' recipe in OE et
EXTRA_OECONF = "--enable-nautilus-sendto=no"

RRECOMMENDS_${PN} += "obexd obex-data-server"
RCONFLICTS_${PN} = "bluez-gnome"

do_configure_prepend() {
    sed -i -e s:docs::g ${S}/Makefile.am
	echo "EXTRA_DIST = version.xml" > gnome-doc-utils.make
	echo "EXTRA_DIST = version.xml" > gtk-doc.make
}

FILES_${PN}-dbg += "${libdir}/gnome-bluetooth/plugins/.debug/"

