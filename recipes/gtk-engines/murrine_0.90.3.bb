DESCRIPTION = "GTK murrine"
LICENSE = "GPLv2"
SECTION = "x11/base"
DEPENDS = "gtk+ cairo"

inherit gnome gtk-binver

SRC_URI[archive.md5sum] = "58a10b5c7b5e114a8a7ff5705fe274f5"
SRC_URI[archive.sha256sum] = "c61ff7614e68b705560612ea7485454d1a7947422ac8cfe11d75e45370e2f0ba"

PACKAGES =+ "gtk-engine-murrine"
FILES_gtk-engine-murrine += "${datadir}/gtk-engines ${libdir}/gtk-2.0/*/engines/*.so"
