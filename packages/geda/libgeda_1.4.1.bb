LICENSE = "GPLv2"
HOMEPAGE = "http://geda.seul.org"
FILES_${PN} += "${datadir}/gEDA ${datadir}/icons ${datadir}/mime"
# NOTE: Old KDE integration ${datadir}/mimelnk/application/*.desktop are ignored intentionally (utx)

DEPENDS = "zlib gtk+ guile libpng"

SRC_URI = "http://geda.seul.org/release/v1.4/${PV}/${P}.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-update-mime-database"

do_install_prepend() {
	sed -i 's:${STAGING_DIR_HOST}::g' libgeda.pc
}

do_stage () {
	autotools_stage_all
}
