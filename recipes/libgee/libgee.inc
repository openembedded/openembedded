DESCRIPTION = "libgee is a collection library providing GObject-based interfaces \
and classes for commonly used data structures."
HOMEPAGE = "http://live.gnome.org/Libgee"
SECTION = "libs"
DEPENDS = "glib-2.0"
BBCLASSEXTEND = "native"
LICENSE = "LGPL"
INC_PR = "r5"
PE = "1"

inherit autotools vala

do_configure() {
        gnu-configize
        oe_runconf
}

