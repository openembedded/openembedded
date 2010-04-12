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



SRC_URI[md5sum] = "043c21b35c7f00b21745c8a3a61c12ac"
SRC_URI[sha256sum] = "a04f41837a995c1f1834a66be41bc0b7237ee181314607dfb0ef733984765d04"
