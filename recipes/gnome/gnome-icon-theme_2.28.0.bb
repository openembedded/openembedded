SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "icon-naming-utils-native glib-2.0 intltool-native"

RDEPENDS = "hicolor-icon-theme"
RRECOMMENDS = "librsvg-gtk"

PR = "r3"

inherit gnome

EXTRA_OECONF = "--disable-hicolor-check"

FILES_${PN} += "${datadir}/*"
