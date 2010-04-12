DESCRIPTION = "Gnome application programming libraries"
LICENSE = "GPL"
SECTION = "x11/gnome/libs"
PR = "r0"

inherit gnome

DEPENDS = "gconf-native gnome-vfs libbonobo esound"

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
autotools_stage_all
}

SRC_URI[archive.md5sum] = "bf53815df10db62bbf00defd4100b8d8"
SRC_URI[archive.sha256sum] = "4d091bd00e01392d65a856ca5b9fe648025c5988c844d58b25341a275b760fa7"
