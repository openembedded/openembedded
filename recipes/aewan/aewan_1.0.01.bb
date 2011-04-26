DESCRIPTION = "Aewan is a multi-layered ascii-art/animation editor"
HOMEPAGE = "http://aewan.sourceforge.net/"
SECTION = "console/utils"
DEPENDS = "ncurses zlib"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "89545338d1eba311297b520f9dc1b976"
SRC_URI[sha256sum] = "5266dec5e185e530b792522821c97dfa5f9e3892d0dca5e881d0c30ceac21817"
