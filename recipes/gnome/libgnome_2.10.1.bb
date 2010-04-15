DESCRIPTION = "Gnome application programming libraries"
LICENSE = "GPL"
SECTION = "x11/gnome/libs"

PR = "r2"

inherit gnome

DEPENDS = "gconf-native gnome-vfs libbonobo"

EXTRA_OECONF = "--disable-gtk-doc"

SRC_URI[archive.md5sum] = "dfb1a9b5fd25da8680a166c83ce0b6a8"
SRC_URI[archive.sha256sum] = "9cf2d20f528470b2fc7995aea314c5898fad654fde265880002de0669b869c27"
