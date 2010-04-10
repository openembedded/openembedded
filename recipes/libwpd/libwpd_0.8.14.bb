LICENSE = "LGPL"
DESCRIPTION = "libwpd is a C++ library designed to help process WordPerfect documents."
HOMEPAGE = "http://libwpd.sourceforge.net/index.html"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"
DEPENDS = "libgsf"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "64d66018897d759358f454010b6e75d2"
SRC_URI[sha256sum] = "01744fa637ad16a8ffaefb1aa7b9b42a56e92f0a2a18753f6720a85aa289d4eb"
