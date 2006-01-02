LICENSE = "GPL"
SECTION = "x11/gnome"
SRC_URI = "${GNOME_MIRROR}/${PN}/1.3/${PN}-${PV}.tar.bz2"
DEPENDS = "glib intltool-native"
PR="r1"

FILES_${PN} += "${datadir}/*"

EXTRA_OECONF = "--disable-hicolor-check"

inherit autotools pkgconfig
