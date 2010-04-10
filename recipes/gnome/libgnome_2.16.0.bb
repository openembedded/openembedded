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

SRC_URI[archive.md5sum] = "b3f030f6c677b0e1bcfca7c7e58d6c4a"
SRC_URI[archive.sha256sum] = "78a2d66bea1d856f06fbd3348abceded8975f09c767a17f58e1d9cd8011ab710"
