DESCRIPTION = "Library for interacting with ID3 tags."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "zlib"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/mad/libid3tag-${PV}.tar.gz"
S = "${WORKDIR}/libid3tag-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "-enable-speed"

do_stage() {
    autotools_stage_all
}
