LICENSE = "GPLv2"
HOMEPAGE = "http://geda.seul.org"
FILES_${PN} += "${datadir}/gEDA ${datadir}/icons"

DEPENDS = "gtk+ libgeda"

SRC_URI = "http://geda.seul.org/release/v1.4/${PV}/${P}.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-update-desktop-database"
