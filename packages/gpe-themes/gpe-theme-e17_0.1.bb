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


