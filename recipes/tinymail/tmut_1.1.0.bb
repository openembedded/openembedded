DESCRIPTION = "Tmut is a really small E-Mail client based on Tinymail"
SECTION = "x11/utils"
LICENSE = "LGPL"
DEPENDS = "gtk+ glib-2.0 gnome-vfs gconf-dbus libtinymail"
PR = "r0"

SRC_URI = "http://tinymail.org/files/tmut/releases/v1.1/v${PV}/${PN}-${PV}.tar.bz2"

inherit pkgconfig autotools
