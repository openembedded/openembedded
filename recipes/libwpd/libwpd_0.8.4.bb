LICENSE = "LGPL"
DESCRIPTION = "libwpd is a C++ library designed to help process WordPerfect documents."
HOMEPAGE = "http://libwpd.sourceforge.net/index.html"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"
DEPENDS = "libgsf"

inherit autotools pkgconfig


do_stage() {
autotools_stage_all
}

SRC_URI[md5sum] = "0461d4bf2da534b4bed041b67d7f7064"
SRC_URI[sha256sum] = "b6393088bf6c49b72a07d2aec7d84d14f6cab0ab00ad177c17157f03095f2096"
