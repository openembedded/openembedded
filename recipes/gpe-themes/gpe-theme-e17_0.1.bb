DESCRIPTION =	"GTK+ enlightenment theme adjusted for GPE"
LICENSE = 	"MIT + GPL"
PR =		"r0"

#it doesn't really depends on it, but it's nice to make OE build it
RDEPENDS =		"gtk+"

FILES_${PN} =		"${datadir}/themes/"
SRC_URI =		"http://linuxtogo.org/~koen/gpe/themes/${P}.tar.gz"

do_install() {
install -d ${D}${datadir}/themes/
cp -R ${WORKDIR}/usr/share/themes/e17-bling/  ${D}${datadir}/themes/
}



SRC_URI[md5sum] = "c6e9d80180861d0a744b313c59691655"
SRC_URI[sha256sum] = "40df3e20e7c563b49ae0d5b4ff9151d0b9062815e7222f361b949cb60d9b0b59"
