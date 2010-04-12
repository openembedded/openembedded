DESCRIPTION = "Window navigation construction toolkit"
LICENSE = "LGPL"
SECTION = "x11/libs"
DEPENDS = "gtk+ gdk-pixbuf-csource-native"

inherit gnome

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "a9311661aa954e7c918439b6dd578792"
SRC_URI[archive.sha256sum] = "d90be36d2fefa33a9287ed6dc41141213a06463f91d69d847da6b2e59c16b947"
