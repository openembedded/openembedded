LICENSE = "GPLv2"
HOMEPAGE = "http://geda.seul.org"

DEPENDS = "gtk+ libgeda"

SRC_URI = "http://geda.seul.org/release/v1.4/${PV}/${P}.tar.gz"

inherit autotools pkgconfig
