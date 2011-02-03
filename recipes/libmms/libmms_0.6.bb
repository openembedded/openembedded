DESCRIPTION = "MMS stream protocol library"
HOMEPAGE = "http://sourceforge.net/projects/libmms/"
SECTION = "libs/multimedia"
LICENSE = "LGPLv2+"
DEPENDS = "glib-2.0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"
SRC_URI[md5sum] = "650ad04a4c8bd79246390b81b29680b6"
SRC_URI[sha256sum] = "1f894f33b5e0334bd7c75343480bdf3a9cf79232aa92085c03f1a67e7d4ceb9d"

inherit autotools pkgconfig
