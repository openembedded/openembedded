LICENSE = "LGPL"
DEPENDS = "glib-2.0"

inherit gnome lib_package

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
	autotools_stage_all
}
