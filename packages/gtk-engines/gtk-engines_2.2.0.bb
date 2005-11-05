LICENSE = "GPL"
SECTION = "x11/base"
DESCRIPTION = "GTK theme engines"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "gtk+"

PACKAGES += " gtk-engine-pixmap gtk-engine-redmond95 gtk-engine-metal gtk-theme-metal gtk-theme-redmond95"
FILES_gtk-engine-pixmap = "${libdir}/gtk-2.0/*/engines/libpixmap.so"
FILES_gtk-engine-redmond95 = "${libdir}/gtk-2.0/*/engines/libredmond95.so"
FILES_gtk-engine-metal = "${libdir}/gtk-2.0/*/engines/libmetal.so"
FILES_gtk-theme-redmond95 = "${datadir}/themes/Redmond95"
FILES_gtk-theme-metal = "${datadir}/themes/Metal"
DEPENDS_gtk-theme-redmond95 = "gtk-engine-redmond95"
DEPENDS_gtk-theme-metal = "gtk-engine-metal"

SRC_URI = "${GNOME_MIRROR}/${PN}/2.2/${PN}-${PV}.tar.bz2"

inherit autotools pkgconfig
