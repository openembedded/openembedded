LICENSE = "GPLv2"
HOMEPAGE = "http://lpg.ticalc.org/prj_tilp/index.html"

SRC_URI = "${SOURCEFORGE_MIRROR}/tilp/${P}.tar.gz"

inherit autotools pkgconfig

do_stage() {
autotools_stage_all
}

