DESCRIPTION = "Tmut is a really small E-Mail client based on Tinymail"
SECTION = "x11/utils"
LICENSE = "LGPL"
DEPENDS = "gtk+ glib-2.0 gnome-vfs gconf libtinymail"
PR = "r1"

SRC_URI = "http://tinymail.org/files/tmut/releases/v1.1/v${PV}/${PN}-${PV}.tar.bz2"

inherit pkgconfig autotools

SRC_URI[md5sum] = "6178256c82efcd02b5d50f2289c13d9b"
SRC_URI[sha256sum] = "ac5dcd76faf25e0c40e91a4bcfea7f6f1bec33d361ad89a6e2f6fc63fa26590e"
