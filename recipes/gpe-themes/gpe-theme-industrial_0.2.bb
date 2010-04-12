DESCRIPTION = "GTK+ industrial theme adjusted for GPE"
LICENSE = "GPL"

#it doesn't really depends on it, but it's nice to make OE build it
DEPENDS = "gtk-engines"
RDEPENDS = "gtk-engine-industrial"

FILES_${PN} = "${datadir}/themes/"
SRC_URI = "http://dominion.thruhere.net/koen/pda/files/${P}.tar.gz"

do_install() {
install -d ${D}${datadir}/themes/
cp -R ${WORKDIR}/Industrial ${D}${datadir}/themes/
}



SRC_URI[md5sum] = "756f38d53eaae09d87655f3ed3a660c2"
SRC_URI[sha256sum] = "4524df3931041dc31985014b5f581396217b0b3f6aa00225d98060f1a9cc1b67"
