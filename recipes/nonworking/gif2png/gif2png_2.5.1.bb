DESCRIPTION = "gif2png"
LICENSE = "GPL"
SECTION = "console/utils"
PRIORITY = "optional"
DEPENDS = "zlib libpng"

SRC_URI = "http://www.catb.org/~esr/gif2png/gif2png-${PV}.tar.gz"

inherit autotools


SRC_URI[md5sum] = "85bb8ee345fc41c218de19dda0164806"
SRC_URI[sha256sum] = "90825b05b675890bd405767a973d3c8c90eae36d22a7be6307e07a2e3c760d89"
