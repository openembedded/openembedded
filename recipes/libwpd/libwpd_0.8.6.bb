LICENSE = "LGPL"
DESCRIPTION = "libwpd is a C++ library designed to help process WordPerfect documents."
HOMEPAGE = "http://libwpd.sourceforge.net/index.html"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"
DEPENDS = "libgsf"

inherit autotools pkgconfig


do_stage() {
autotools_stage_all
}

SRC_URI[md5sum] = "464a390c66511831821de81b887d3e61"
SRC_URI[sha256sum] = "05a67a8b8d907ebcbac0e8505fc59fc50731ba9f73b8c177898ce41d0575bb17"
