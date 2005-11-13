LICENSE = "GPL"
HOMEPAGE = "http://qof.sourceforge.net/"

PR = "pre1"
DEPENDS = "glib-2.0 libtool zlib"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}-pre1.tar.gz \
			file://fix-includes.patch;patch=1"

S = "${WORKDIR}/${P}-pre1"

FILES_${PN} += "/usr/share/xml"
PARALLEL_MAKE=""

inherit autotools pkgconfig


do_stage() {
autotools_stage_all
}


