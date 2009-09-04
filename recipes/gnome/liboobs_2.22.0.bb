LICENSE = "LGPL"
DEPENDS = "glib-2.0 dbus system-tools-backends"

inherit gnome lib_package

do_stage() {
	autotools_stage_all
}
