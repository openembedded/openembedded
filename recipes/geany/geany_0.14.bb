DESCRIPTION = "Text editor with some IDE functionality"
HOMEPAGE = "http://geany.sf.net"
SECTION = "editors"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/geany/${P}.tar.bz2"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-plugins --disable-vte"

SRC_URI[md5sum] = "c6c22c7f9feff81a15f5c8ece03b87c1"
SRC_URI[sha256sum] = "619d59b339e1be7687058460c105b8f2d4f00e6409e4450dee385e3086fdf6d7"
