LICENSE = "GPL"
HOMEPAGE = "http://qof.sourceforge.net/"

DEPENDS = "glib-2.0 libxml2 libtool zlib"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz \
			file://fix-includes.patch;patch=1"


FILES_${PN} += "/usr/share/xml"
PARALLEL_MAKE=""

inherit autotools pkgconfig


do_stage() {
autotools_stage_all
}


