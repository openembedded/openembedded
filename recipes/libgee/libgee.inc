DESCRIPTION = "libgee is a collection library providing GObject-based interfaces \
and classes for commonly used data structures."
HOMEPAGE = "http://live.gnome.org/Libgee"
SECTION = "libs"
DEPENDS = "glib-2.0"
BBCLASSEXTEND = "native"
DEPENDS_virtclass-native = "glib-2.0-native"
LICENSE = "LGPL"
PE = "1"

inherit autotools vala
