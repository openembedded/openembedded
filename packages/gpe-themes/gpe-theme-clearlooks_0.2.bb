DESCRIPTION =	"GTK+ clearlooks theme adjusted for GPE"
MAINTAINER =	"Koen Kooi <koen@handhelds.org>"
PR=		"r1"

#it doesn't really depends on it, but it's nice to make OE build it
DEPENDS =		"gtk-engines"
RDEPENDS =		"gtk-engine-clearlooks"

FILES_${PN} =	"${datadir}/themes/"
SRC_URI =		"http://dominion.kabel.utwente.nl/koen/pda/files/${P}.tar.gz"

do_install() {
install -d ${D}${datadir}/themes/
cp -dpR ${WORKDIR}/Clearlooks ${D}${datadir}/themes/ 
}


