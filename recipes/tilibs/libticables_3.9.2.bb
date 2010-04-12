LICENSE = "GPLv2"
HOMEPAGE = "http://lpg.ticalc.org/prj_tilp/index.html"

SRC_URI = "${SOURCEFORGE_MIRROR}/tilp/${P}.tar.gz"

inherit autotools pkgconfig

do_stage() {
autotools_stage_all
}

SRC_URI[md5sum] = "354675bfbd881082a9447efde9935226"
SRC_URI[sha256sum] = "1c091859f09d5a38c76f0d64a93db46aa2b5d637c8a7370d348f21e7be324c37"
