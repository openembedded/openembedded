SRC_URI = "http://ewi546.ewi.utwente.nl/OE/source/${P}.tar.gz"


LICENSE = "LGPL"
DEPENDS = "libopensync openobex bluez-libs"
RRECOMMENDS = "multisync"
HOMEPAGE = "http://www.opensync.org/"

inherit autotools pkgconfig

FILES_${PN} += "${datadir} ${libdir}"

do_install() {
install -d ${D}${datadir}/opensync/defaults
install -d ${D}${libdir}/opensync/plugins
install -m 644 src/irmc-sync ${D}${datadir}/opensync/defaults
install -m 755 src/.libs/irmc_sync.so ${D}${libdir}/opensync/plugins/
}

SRC_URI[md5sum] = "52f86db50d653f5af0adefeb76cf9a31"
SRC_URI[sha256sum] = "db7250647b86dc8d0bd45c73d454d73ca182c88f6ffe2ccf1760f40be81080f2"
