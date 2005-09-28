DESCRIPTION =	"GTK+ industrial theme adjusted for GPE"
MAINTAINER =	"Koen Kooi <koen@handhelds.org>"
PR=		"r0"

#it doesn't really depends on it, but it's nice to make OE build it
DEPENDS =		"gtk-engines"
RDEPENDS =		"gtk-engine-industrial"

FILES_${PN} =	"${datadir}/themes/"
SRC_URI =		"http://dominion.kabel.utwente.nl/koen/pda/files/${P}.tar.gz"

do_install() {
install -d ${D}${datadir}/themes/
cp -R ${WORKDIR}/Industrial ${D}${datadir}/themes/ 
}


