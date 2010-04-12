DESCRIPTION = "Window navigation construction toolkit"
LICENSE = "LGPL"
SECTION = "x11/libs"
DEPENDS = "gtk+ gdk-pixbuf-csource-native"

inherit gnome

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "9c6d134dc1d454b4c5a717638caa56c6"
SRC_URI[archive.sha256sum] = "ea7945a131b67d4cf6bd02e41b0008d6aa1575d1aed75a0019d3c63cb61d07ea"
