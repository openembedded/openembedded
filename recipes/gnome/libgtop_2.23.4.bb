LICENSE = "LGPL"
DEPENDS = "glib-2.0"

inherit gnome lib_package

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "bb37766ba407983a8e055eb4705a1a81"
SRC_URI[archive.sha256sum] = "7d9b0e68b4e84e7938197c5240023d3b6840026cfc9f83bdab202fbab4029a9b"
