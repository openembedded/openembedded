HOMEPAGE = "http://qof.sourceforge.net/"
LICENSE = "GPL"

DEPENDS = "glib-2.0 libxml2 libtool zlib"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz \
          "
inherit autotools pkgconfig

EXTRA_OECONF = "--disable-error-on-warning"

PARALLEL_MAKE = ""

do_stage() {
         autotools_stage_all
}

FILES_${PN} += "/usr/share/xml"

