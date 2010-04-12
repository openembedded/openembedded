SRC_URI = "http://ewi546.ewi.utwente.nl/OE/source/libopensync-${PV}.tar.gz"


LICENSE = "LGPL"
DEPENDS = "sqlite3 libxml2 zlib glib-2.0"
HOMEPAGE = "http://www.opensync.org/"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-python"
LEAD_SONAME = "libopensync.so"

FILES_${PN} += " ${libdir}/opensync/formats/*.so"

do_stage() {
autotools_stage_all
}


SRC_URI[md5sum] = "ce94a69fb7ae7533d1f8828b6402cec8"
SRC_URI[sha256sum] = "f9c803ba28d5deb18d9feb5c7818ce99325b09204b7dc0447798f2f47a657a46"
