LICENSE = "LGPL"
DESCRIPTION = "libwpd is a C++ library designed to help process WordPerfect documents."
HOMEPAGE = "http://libwpd.sourceforge.net/index.html"
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"


inherit autotools pkgconfig


do_stage() {
autotools_stage_all
}
