LICENSE = "LGPL"
HOMEPAGE = "http://www.opensync.org/"

DEPENDS = "sqlite3 libxml2 zlib glib-2.0"

SRC_URI = "http://www.opensync.org/download/releases/${PV}/${PN}-${PV}.tar.bz2"

inherit autotools pkgconfig lib_package

EXTRA_OECONF = "--disable-python"
LEAD_SONAME = "libopensync.so"

FILES_${PN} += " ${libdir}/opensync/formats/*.so"
FILES_${PN}-dbg += " ${libdir}/opensync/formats/.debug/*.so"

require opensync-unpack.inc

SRC_URI[md5sum] = "f563ce2543312937a9afb4f8445ef932"
SRC_URI[sha256sum] = "3394bae1e3bcfe463d139a367ba5ebe73d968df128c871842dcb4965a725d0dc"
