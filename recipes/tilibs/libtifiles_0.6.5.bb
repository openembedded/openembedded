LICENSE = "GPLv2"
HOMEPAGE = "http://lpg.ticalc.org/prj_tilp/index.html"

SRC_URI = "${SOURCEFORGE_MIRROR}/tilp/${P}.tar.gz"

inherit autotools pkgconfig

do_stage() {
autotools_stage_all
}


SRC_URI[md5sum] = "cfac4188328b888e80995f0ef3f6e0bf"
SRC_URI[sha256sum] = "2216944bee1bafe60bf64ec01f6b8cd27ed9adfd2d1a185b43617d6e80d8b2c8"
