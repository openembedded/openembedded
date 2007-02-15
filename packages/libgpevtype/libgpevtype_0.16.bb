LICENSE     = "LGPL"
DESCRIPTION = "Data interchange library for GPE"
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "libmimedir libeventdb"
PR          = "r0"

inherit pkgconfig gpe autotools

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2"

do_stage () {
	autotools_stage_all
}

