LICENSE = "GPL"
SECTION = "x11/gnome/libs"

PR = "r2"

DEPENDS = "libxml2 glib-2.0 pango libart-lgpl fontconfig popt gnome-common"

inherit flow-lossage pkgconfig gnome

SRC_URI[archive.md5sum] = "f742bb321fab833b67270f7b86af0fdb"
SRC_URI[archive.sha256sum] = "4c8c61d56cded77108d74467a4312e7b9d3bb5236fd1e09f6c3b1205ef5d3d32"
