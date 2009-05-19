DESCRIPTION = "A grid-entry natural handwriting input panel"
SECTION = "x11/input"
AUTHOR = "Michael Levin"
LICENSE = "GPL"
DEPENDS = "gtk+ libxtst"

SRC_URI = "http://pub.risujin.org/cellwriter/${PN}-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--without-gnome"

FILES_${PN} += "${datadir}/icons"
