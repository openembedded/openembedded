DESCRIPTION = "A grid-entry natural handwriting input panel"
SECTION = "x11/input"
AUTHOR = "Michael Levin"
LICENSE = "GPL"
DEPENDS = "gtk+ libxtst"

SRC_URI = "http://pub.risujin.org/cellwriter/${PN}-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--without-gnome"

FILES_${PN} += "${datadir}/icons"

SRC_URI[md5sum] = "72b4e552a32d6acd888da0b88aeebbdd"
SRC_URI[sha256sum] = "6ab6fa697938af0fc8b587ccd7c5889087800569e558b97797963c6ee2fada0c"
