require uim.inc
DEPENDS = "gtk+ anthy intltool-native"
inherit native autotools pkgconfig
PR = "r2"

EXTRA_OECONF += "--disable-xim"
