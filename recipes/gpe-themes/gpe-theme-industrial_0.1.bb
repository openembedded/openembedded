DESCRIPTION =	"GTK+ industrial theme adjusted for GPE"
LICENSE = 	"GPL"
PR =		"r0"

#it doesn't really depends on it, but it's nice to make OE build it
DEPENDS =		"gtk-engines"
RDEPENDS =		"gtk-engine-industrial"

FILES_${PN} =	"${datadir}/themes/"
SRC_URI =		"http://dominion.thruhere.net/koen/pda/files/${P}.tar.gz"

do_install() {
install -d ${D}${datadir}/themes/
cp -R ${WORKDIR}/Industrial ${D}${datadir}/themes/
}



SRC_URI[md5sum] = "75898910db553923aa312ed2b1545364"
SRC_URI[sha256sum] = "6aeb1dd991f0e0bcc11562061148051520562c81dc6bf18c03f0cc86a72f6093"
