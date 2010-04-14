SRC_URI = "http://ewi546.ewi.utwente.nl/OE/source/${P}.tar.gz"


LICENSE = "LGPL"
DEPENDS = "libopensync"
RRECOMMENDS = "multisync"
HOMEPAGE = "http://www.opensync.org/"

inherit autotools pkgconfig

FILES_${PN} += "${datadir} ${libdir}"
do_install() {
install -d ${D}${datadir}/opensync/defaults
install -d ${D}${libdir}/opensync/plugins
install -m 644 src/file-sync ${D}${datadir}/opensync/defaults
install -m 755 src/.libs/file_sync.so ${D}${libdir}/opensync/plugins/file_sync.so
}

SRC_URI[md5sum] = "a9ffd002169406fb31eee885c9742c26"
SRC_URI[sha256sum] = "c03ad432d46e8f562ad4eaa08972c5bd229fdc45e5c01ac9af094cbfc38cdf59"
