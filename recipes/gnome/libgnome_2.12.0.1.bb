DESCRIPTION = "Gnome application programming libraries"
LICENSE = "GPL"
SECTION = "x11/gnome/libs"
PR = "r2"

inherit gnome

DEPENDS = "gconf-native gnome-vfs libbonobo"

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
autotools_stage_all
}

SRC_URI[archive.md5sum] = "f239a7ab132d2ec9039bb2537cca1e92"
SRC_URI[archive.sha256sum] = "f4cd8f6df545328b2b969d1fa8762d5398f7f6c517c7fac730f1d2196e4cf624"
