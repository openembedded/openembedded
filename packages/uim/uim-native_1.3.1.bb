require uim.inc
DEPENDS = "gtk+ anthy intltool-native"
inherit native autotools pkgconfig
PR = "r1"

S = "${WORKDIR}/uim-${PV}"
