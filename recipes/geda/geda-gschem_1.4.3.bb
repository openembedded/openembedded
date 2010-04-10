LICENSE = "GPLv2"
HOMEPAGE = "http://www.gpleda.org/"
FILES_${PN} += "${datadir}/gEDA ${datadir}/icons"
PR = "r1"

DEPENDS = "gtk+ libgeda"

SRC_URI = "http://geda.seul.org/release/v1.4/${PV}/${P}.tar.gz \
	   file://bad-include.patch;patch=1"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-update-desktop-database"

SRC_URI[md5sum] = "76eef656ba4e27c6083fa29b3a5dfb08"
SRC_URI[sha256sum] = "6952601966e0f28b9436286178a488849a78da1581c282944d2be34e9a09eec7"
