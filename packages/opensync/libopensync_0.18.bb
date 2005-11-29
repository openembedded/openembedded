SRC_URI = "http://ewi546.ewi.utwente.nl/OE/source/libopensync-${PV}.tar.gz"


LICENSE = "LGPL"
DEPENDS = "sqlite3 libxml2 zlib glib-2.0"
HOMEPAGE = "http://www.opensync.org/"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-python"
LEAD_SONAME = "libopensync.so"

FILES_${PN} += " ${libdir}/opensync/formats/*.so"

do_stage() {
autotools_stage_all
}

