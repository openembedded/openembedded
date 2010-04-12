DESCRIPTION = "Window navigation construction toolkit"
LICENSE = "LGPL"
SECTION = "x11/libs"
DEPENDS = "gtk+ gdk-pixbuf-csource-native"

inherit gnome

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "860cd0ddce03c41a328e580d4efd4654"
SRC_URI[archive.sha256sum] = "8cf49cf1d882ceb0b7b3a984ec350e5e2e4d608fec97911a0b0acf36a18d4df4"
