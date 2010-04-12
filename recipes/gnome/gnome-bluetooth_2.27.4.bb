LICENSE = "GPL"
SECTION = "x11/gnome"

inherit autotools gnome pkgconfig

DEPENDS = "obexd obex-data-server gconf gtk+ dbus-glib libunique libnotify hal bluez4 gnome-keyring"
RRECOMMENDS_${PN} += "obexd obex-data-server"
RCONFLICTS_${PN} = "bluez-gnome"

do_configure_prepend() {
    sed -i -e s:docs::g ${S}/Makefile.am
	echo "EXTRA_DIST = version.xml" > gnome-doc-utils.make
	echo "EXTRA_DIST = version.xml" > gtk-doc.make
}


SRC_URI[archive.md5sum] = "e34180aa90d5d718b819572b21b76d08"
SRC_URI[archive.sha256sum] = "250fede462d5ec0576c0ab9c7f965fb56dc5de6e1180405da8cf0e867a2eca3a"
