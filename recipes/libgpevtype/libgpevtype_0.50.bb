LICENSE     = "LGPL"
DESCRIPTION = "Data interchange library for GPE"
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "libmimedir libeventdb libtododb"
PR          = "r1"

inherit pkgconfig gpe autotools

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2"


do_stage () {
	autotools_stage_all
}



SRC_URI[md5sum] = "4d7a20b215c53b73786690e895f05750"
SRC_URI[sha256sum] = "a390032e637621ef8a8ff2ae3f73cf8f74f10b2f999b359253b137f1341f482e"
