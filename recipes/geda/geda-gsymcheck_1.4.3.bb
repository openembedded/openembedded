LICENSE = "GPLv2"
HOMEPAGE = "http://www.gpleda.org/"
FILES_${PN} += "${datadir}/gEDA ${datadir}/icons"
PR = "r1"

DEPENDS = "gtk+ libgeda"

SRC_URI = "http://geda.seul.org/release/v1.4/${PV}/${P}.tar.gz"

inherit autotools pkgconfig

SRC_URI[md5sum] = "764613c24a752281a4f5d5432e53d0d2"
SRC_URI[sha256sum] = "e6d9517eaea4383e724502c607d720a3cd4bf560459f5f2196e19d0c5bb3da2c"
