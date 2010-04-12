DESCRIPTION = "Gnome application programming libraries"
LICENSE = "GPL"
SECTION = "x11/gnome/libs"
PR = "r0"

inherit gnome lib_package

DEPENDS = "gconf-native gnome-vfs libbonobo esound"

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
autotools_stage_all
}

SRC_URI[archive.md5sum] = "73426589d7c6fa3266fe4e8f3be2f5b5"
SRC_URI[archive.sha256sum] = "53e3b241343c7ea9c4a8db4ca898fd7020c281f1400826d899b841d760dd5ba9"
