require uim.inc
DEPENDS = "gtk+ anthy intltool-native"
inherit native autotools pkgconfig

S = "${WORKDIR}/uim-${PV}"
