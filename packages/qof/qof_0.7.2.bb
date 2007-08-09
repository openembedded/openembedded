DESCRIPTION = "set of C Language utilities for performing generic structured \
complex queries on a set of data held by a set of C/C++ objects."
AUTHOR = "Linas Vepstas, Neil Williams"
HOMEPAGE = "http://qof.sf.net/"
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

