LICENSE = "GPL"
SECTION = "x11/gnome"

PR = "r2"

inherit autotools gnome pkgconfig

DEPENDS = "obexd gconf-dbus gtk+ dbus-glib libunique libnotify hal bluez4 gnome-keyring"
RDEPENDS += "obexd"
RCONFLICTS_${PN} = "bluez-gnome"

do_configure_prepend() {
    sed -i -e s:docs::g ${S}/Makefile.am
}

