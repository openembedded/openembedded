LICENSE = "GPLv2"
HOMEPAGE = "http://www.gpleda.org/"
FILES_${PN} += "${datadir}/gEDA ${datadir}/icons ${datadir}/mime/packages"
# NOTE: Old KDE integration ${datadir}/mimelnk/application/*.desktop are ignored intentionally
PR = "r1"

DEPENDS = "zlib gtk+ guile libpng"

SRC_URI = "http://geda.seul.org/release/v1.4/${PV}/${P}.tar.gz"

inherit autotools pkgconfig mime

EXTRA_OECONF = "--disable-update-mime-database --disable-static"

do_install_prepend() {
	sed -i 's:${STAGING_DIR_HOST}::g' libgeda.pc
}

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "f4254f345b5d1a1f3ae4e2e27ae38b0a"
SRC_URI[sha256sum] = "f3687c7308231634619de278b5880cccd6b9b3fc04a4c1b1cf8b2e3131f6f158"
