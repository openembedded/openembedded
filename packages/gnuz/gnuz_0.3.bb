DESCRIPTION = "gnuZ is a Lemmings style game"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
LICENSE = "GPL"
AUTHOR = "Lukas Fraser"
HOMEPAGE = "http://gnuz.4cows.net/eraser/gnuz/"
PR = "r1"

APPTYPE = "binary"
APPNAME = "gnuz"
APPDESKTOP = "${S}/data/"

SRC_URI = "http://gnuz.4cows.net/eraser/gnuz/gnuz_0.3.tar.gz \
           http://www.hrw.one.pl/_pliki/oe/files/gnuz-levels-0.3.tar.bz2"

S = "${WORKDIR}/gnuz"

inherit opie

do_install_append() {

        install -d ${D}${palmtopdir}/apps/Games \
                   ${D}${palmtopdir}/pics \
                   ${D}${palmtopdir}/share/gnuz/levels

        install -m 0644 data/gnuz.png ${D}${palmtopdir}/pics/
        install -m 0644 ${WORKDIR}/gnuz-levels/share/gnuz/levels/* ${D}${palmtopdir}/share/gnuz/levels/
        install -m 0644 ${WORKDIR}/gnuz-levels/share/gnuz/*images.dat ${D}${palmtopdir}/share/gnuz/
}
