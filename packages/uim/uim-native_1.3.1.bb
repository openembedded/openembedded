require uim.inc
DEPENDS = "gtk+ anthy intltool-native"
inherit native autotools pkgconfig
PR = "r2"

S = "${WORKDIR}/uim-${PV}"

EXTRA_OECONF += "--disable-xim"
