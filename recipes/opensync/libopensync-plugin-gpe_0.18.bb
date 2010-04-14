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
install -m 644 src/gpe-sync ${D}${datadir}/opensync/defaults
install -m 755 src/.libs/gpe_sync.so ${D}${libdir}/opensync/plugins/
}

SRC_URI[md5sum] = "6b35732f34aad4becfc24ee500d32c9b"
SRC_URI[sha256sum] = "218e8d5194d866109db3419c66d071cdbd319446288e7012ed135d4a6b8a3762"
