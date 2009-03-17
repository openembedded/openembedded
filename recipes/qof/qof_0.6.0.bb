HOMEPAGE = "http://qof.sourceforge.net/"
LICENSE = "GPL"

DEPENDS = "glib-2.0 libxml2 libtool zlib"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz \
           file://libsql-no-host-includes.patch;patch=1 \
           file://fix-includes.patch;patch=1 \
          "

inherit autotools pkgconfig

PARALLEL_MAKE = ""

do_stage() {
         autotools_stage_all
}

FILES_${PN} += "/usr/share/xml"

