LICENSE = "LGPL"
DESCRIPTION = "libwpd is a C++ library designed to help process WordPerfect documents."
HOMEPAGE = "http://libwpd.sourceforge.net/index.html"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"
DEPENDS = "libgsf"

inherit autotools pkgconfig


do_stage() {
autotools_stage_all
}
