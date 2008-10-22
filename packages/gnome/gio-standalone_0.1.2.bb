DESCRIPTION = "gio is a platform independent file and I/O abstraction library"
LICENSE = "LGPL"
DEPENDS = "glib-2.0"
PR = "r0"

inherit gnome

PACKAGES =+ "libgio"
FILES_libgio = "${libdir}/libgio.so.*"

do_stage() {
	autotools_stage_all
}

