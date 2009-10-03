LICENSE = "GPLv2"
HOMEPAGE = "http://geda.seul.org"
FILES_${PN} += "${datadir}/gEDA ${datadir}/icons"

DEPENDS = "gtk+ libgeda"

SRC_URI = "http://geda.seul.org/release/v1.4/${PV}/${P}.tar.gz \
      ${@['file://gattrib-gtk218.patch;patch=1', ''][bb.data.getVar('PREFERRED_VERSION_gtk+', d, 1) and bb.data.getVar('PREFERRED_VERSION_gtk+', d, 1).split('.')[0] <= '2' and bb.data.getVar('PREFERRED_VERSION_gtk+', d, 1).split('.')[1] < '18']}"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-update-desktop-database"
