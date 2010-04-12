LICENSE = "GPLv2"
HOMEPAGE = "http://www.gpleda.org/"
PR = "r1"

DEPENDS = "gtk+ libgeda"

SRC_URI = "http://geda.seul.org/release/v1.4/${PV}/${P}.tar.gz"

inherit autotools pkgconfig

SRC_URI[md5sum] = "6305083c37a86f2353a8be40bcf70b99"
SRC_URI[sha256sum] = "26e0d0aa9a24e75af57c27c5710521ed9005dcf4242d912ac0c497653b9a1959"
