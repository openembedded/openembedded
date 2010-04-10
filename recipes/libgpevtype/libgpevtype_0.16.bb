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


SRC_URI[md5sum] = "dc7b99c3799ac1b5b7ef1e21450f20e4"
SRC_URI[sha256sum] = "9a272b4c133be4d828aa58c506ea729bc472434f6475d97ea60b388a40fe444d"
