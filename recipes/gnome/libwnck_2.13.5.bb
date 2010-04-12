DESCRIPTION = "Window navigation construction toolkit"
LICENSE = "LGPL"
SECTION = "x11/libs"
DEPENDS = "gtk+ gdk-pixbuf-csource-native"

inherit gnome

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "cb2da2795f517c713ec98560d078a102"
SRC_URI[archive.sha256sum] = "ce959b7349de056205e992b05c9c914994bc269d2b1d02de85eacd398263aab6"
