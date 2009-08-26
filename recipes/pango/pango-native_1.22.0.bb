
require pango_1.22.0.bb

inherit native

DEPENDS += "glib-2.0-native cairo-native"
PROVIDES = "pango-native"

SRC_URI = "ftp://ftp.gtk.org/pub/gtk/v2.6/pango-${PV}.tar.bz2"

PR = "r0"

