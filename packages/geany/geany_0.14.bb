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
