DESCRIPTION = "gif2png"
LICENSE = "GPL"
SECTION = "console/utils"
PRIORITY = "optional"
DEPENDS = "zlib libpng"

SRC_URI = "http://www.catb.org/~esr/gif2png/gif2png-${PV}.tar.gz"

inherit autotools 

