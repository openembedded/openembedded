DESCRIPTION = "gEDA/gaf's Utilities"
LICENSE = "GPLv2"
HOMEPAGE = "http://www.gpleda.org/"
FILES_${PN} += "${datadir}/gEDA"
PR = "r1"

DEPENDS = "libgeda"

SRC_URI = "http://geda.seul.org/release/v1.4/${PV}/${P}.tar.gz"

inherit autotools pkgconfig

SRC_URI[md5sum] = "55ab23cad7aee2e65fcc742c424e68d4"
SRC_URI[sha256sum] = "d4814c6c11b38a3cce88b193f7a6d18cba46c44f8226716fdde53f0ccc58de49"
