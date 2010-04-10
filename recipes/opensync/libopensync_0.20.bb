LICENSE = "LGPL"
HOMEPAGE = "http://www.opensync.org/"

DEPENDS = "sqlite3 libxml2 zlib glib-2.0"

SRC_URI = "http://www.openembedded.org/sources/libopensync-${PV}.tar.gz"

inherit autotools pkgconfig lib_package

EXTRA_OECONF = "--disable-python"
LEAD_SONAME = "libopensync.so"

FILES_${PN} += " ${libdir}/opensync/formats/*.so"

do_stage() {
autotools_stage_all
}


SRC_URI[md5sum] = "c685e69929333a763c51987b4a19d50d"
SRC_URI[sha256sum] = "5da9e72de291e7654fb59bf40b647633f3afb3cde924bd11b80d6ed26c911feb"
