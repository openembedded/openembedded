LICENSE = "GPL"
SECTION = "x11/gnome"

PR = "r1"

inherit autotools gnome pkgconfig

DEPENDS = "gconf-dbus gtk+ dbus-glib libunique libnotify hal bluez4 gnome-keyring"
RCONFLICTS_${PN} = "bluez-gnome"

do_configure_prepend() {
    sed -i -e s:docs::g ${S}/Makefile.am
}

