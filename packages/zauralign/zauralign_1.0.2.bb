DESCRIPTION = "Zauralign - a game for one player. The player has to align pieces to remove them from the \
board fighting against new pieces which appear after each move." 
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"

SRC_URI = "http://www.Vanille.de/mirror/zauralign-${PV}.tar.gz"
S = "${WORKDIR}/zauralign"

inherit palmtop
export OE_QMAKE_LINK="${CXX}"

do_install() {
        install -d ${D}${palmtopdir}/apps/Games \
        	   ${D}${palmtopdir}/pics/zauralign \
        	   ${D}${palmtopdir}/bin
        install -m 0755 zauralign ${D}${palmtopdir}/bin/
	install -m 0644 zauralign.png ${D}${palmtopdir}/pics/
	install -m 0644 zauralign.desktop ${D}${palmtopdir}/apps/Games/
	cp -a pics/* ${D}${palmtopdir}/pics/zauralign/
}
