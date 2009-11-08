SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "icon-naming-utils-native glib-2.0 intltool-native"

RDEPENDS = "hicolor-icon-theme"
RRECOMMENDS = "librsvg-gtk"

PR = "r2"

inherit gnome

EXTRA_OECONF = "--disable-hicolor-check"

PACKAGE_ARCH = "all"

FILES_${PN} += "${datadir}/*"
