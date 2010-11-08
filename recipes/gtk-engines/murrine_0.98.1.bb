DESCRIPTION = "GTK murrine"
LICENSE = "LGPLv2.1/LGPLv3"
SECTION = "x11/base"
DEPENDS = "gtk+ cairo"

inherit gnome gtk-binver

SRC_URI[archive.md5sum] = "fb8481dd068e27425acf7e91a1250107"
SRC_URI[archive.sha256sum] = "37f4f2d723ce6a03dc1654a142e2477b8d3d23ebb5d7af2f2c85ae72f53d87ae"

PACKAGES =+ "gtk-engine-murrine"
FILES_gtk-engine-murrine += "${datadir}/gtk-engines ${libdir}/gtk-2.0/*/engines/*.so"
