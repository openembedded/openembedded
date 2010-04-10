DESCRIPTION = "An accessibility toolkit for GNOME."
SECTION = "x11/libs"
PRIORITY = "optional"
LICENSE = "LGPL"

DEPENDS = "glib-2.0 gtk-doc-native"

inherit gnome

EXTRA_OECONF = "--disable-glibtest"

do_stage () {
	autotools_stage_all
}



SRC_URI[archive.md5sum] = "719229408019c548855673840679f156"
SRC_URI[archive.sha256sum] = "f7993d26c3606a9b0e32d1eebe716f2294ac37fac014c47744e986fc0ff5e6d1"
