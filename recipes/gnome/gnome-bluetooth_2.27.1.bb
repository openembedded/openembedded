LICENSE = "GPL"
SECTION = "x11/gnome"

inherit autotools gnome pkgconfig

DEPENDS = "gconf-dbus gtk+ dbus-glib libunique libnotify hal bluez4 gnome-keyring"

do_configure_prepend() {
    sed -i -e s:docs::g ${S}/Makefile.am
}

