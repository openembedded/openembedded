LICENSE = "GPLv2"
HOMEPAGE = "http://www.gpleda.org/"
FILES_${PN} += "${datadir}/gEDA ${datadir}/icons"
PR = "r1"

DEPENDS = "gtk+ libgeda"

SRC_URI = "http://geda.seul.org/release/v1.4/${PV}/${P}.tar.gz \
	   file://bad-include.patch;patch=1"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-update-desktop-database"
