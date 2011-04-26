DESCRIPTION = "GooCanvas is a canvas widget for GTK+ that uses the cairo 2D library for drawing"
HOMEPAGE = "http://live.gnome.org/GooCanvas"
SECTION = "x11/libs"
DEPENDS = "gtk+ glib-2.0 cairo gettext"
LICENSE = "GPL"

SRC_URI = "${GNOME_MIRROR}/${PN}/1.0/${PN}-${PV}.tar.bz2"

inherit autotools pkgconfig

SRC_URI[md5sum] = "4858a22239e45cf374195bae520021c2"
SRC_URI[sha256sum] = "1c072ef88567cad241fb4addee26e9bd96741b1503ff736d1c152fa6d865711e"
