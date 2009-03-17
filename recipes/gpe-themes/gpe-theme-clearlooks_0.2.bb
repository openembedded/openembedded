DESCRIPTION = "GTK+ clearlooks theme adjusted for GPE"
LICENSE = "GPL"
PR = "r1"

#it doesn't really depends on it, but it's nice to make OE build it
DEPENDS = "gtk-engines"
RDEPENDS = "gtk-engine-clearlooks"

FILES_${PN} = "${datadir}/themes/"
SRC_URI = "http://dominion.thruhere.net/koen/pda/files/${P}.tar.gz"

do_install() {
install -d ${D}${datadir}/themes/
cp -PpR ${WORKDIR}/Clearlooks ${D}${datadir}/themes/
}


