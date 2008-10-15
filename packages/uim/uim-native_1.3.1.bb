require uim.inc
DEPENDS = "gtk+ anthy intltool-native"
inherit native autotools pkgconfig
FILE_PR = "r2"

S = "${WORKDIR}/uim-${PV}"

EXTRA_OECONF += "--disable-xim"
