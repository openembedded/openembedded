LICENSE = "GPL"
SECTION = "x11/gnome"

PR = "r3"

inherit autotools gnome pkgconfig

DEPENDS = "obexd obex-data-server gconf-dbus gtk+ dbus-glib libunique libnotify hal bluez4 gnome-keyring"
RRECOMMENDS_${PN} += "obexd obex-data-server"
RCONFLICTS_${PN} = "bluez-gnome"

do_configure_prepend() {
    sed -i -e s:docs::g ${S}/Makefile.am
}

