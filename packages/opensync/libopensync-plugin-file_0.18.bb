SRC_URI = "http://ewi546.ewi.utwente.nl/OE/source/${P}.tar.gz"


LICENSE = "LGPL"
DEPENDS = "libopensync"
RRECOMMENDS = "multisync"
HOMEPAGE = "http://www.opensync.org/"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"

inherit autotools pkgconfig

FILES_${PN} += "${datadir} ${libdir}"
do_install() {
install -d ${D}${datadir}/opensync/defaults
install -d ${D}${libdir}/opensync/plugins
install -m 644 src/file-sync ${D}${datadir}/opensync/defaults
install -m 755 src/.libs/file_sync.so ${D}${libdir}/opensync/plugins/file_sync.so
}
