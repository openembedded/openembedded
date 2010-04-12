LICENSE = "GPLv2"
HOMEPAGE = "http://lpg.ticalc.org/prj_tilp/index.html"

DPENDS = "libticables libtifiles"

SRC_URI = "${SOURCEFORGE_MIRROR}/tilp/${P}.tar.gz"

inherit autotools pkgconfig

do_stage() {
autotools_stage_all
}


SRC_URI[md5sum] = "8e93f2a4f4e67a9558d97166b4a4155f"
SRC_URI[sha256sum] = "d9bc0f2f19eb8d21d8319a40dd85c2b1ef45a01499187a424a50173bbdd4ff12"
