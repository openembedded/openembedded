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


SRC_URI[md5sum] = "4a81867ea4212cb5ebd2a6bde91502c0"
SRC_URI[sha256sum] = "5782703fe0cbed713dc17ed10560f55408350310461483715b2c0a58bcd83c49"
