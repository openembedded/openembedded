
require atk_1.27.90.bb

inherit native

DEPENDS += "glib-2.0-native"
PROVIDES = "atk-native"
SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/atk/1.27/atk-${PV}.tar.bz2"

PR = "r0"

