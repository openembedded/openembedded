DESCRIPTION = "GTK+ clearlooks theme adjusted for GPE"
LICENSE = "GPL"

#it doesn't really depends on it, but it's nice to make OE build it
DEPENDS = "gtk-engines"
RDEPENDS = "gtk-engine-clearlooks"

FILES_${PN} = "${datadir}/themes/"
SRC_URI = "http://dominion.thruhere.net/koen/pda/files/${P}.tar.gz"

do_install() {
install -d ${D}${datadir}/themes/
cp -PpR ${WORKDIR}/Clearlooks ${D}${datadir}/themes/
}



SRC_URI[md5sum] = "949d3329e9b9904814302db7132d468a"
SRC_URI[sha256sum] = "f2f1e03e3283f6182d02928cbdb5ea8160f786037d4a135947794da488ebe805"
