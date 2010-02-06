DESCRIPTION = "An accessibility toolkit for GNOME."
SECTION = "x11/libs"
PRIORITY = "optional"
LICENSE = "LGPL"

inherit gnome

DEPENDS = "glib-2.0 gtk-doc-native"


EXTRA_OECONF = "--disable-glibtest"

do_stage () {
	autotools_stage_all
}


