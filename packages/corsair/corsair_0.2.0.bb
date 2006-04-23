DESCRIPTION = "RSS aggregator for Qtopia"
SECTION = "opie/applications"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
LICENSE = "GPL"
AUTHOR = "Joe Rumsey <joe@rumsey.org>"
HOMEPAGE = "http://corsair.sf.net/"
DEPENDS = "opie-pics"
RDEPENDS = "opie-pics"
PV = "0.2.0"
PR = "r4"

SRCDATE = "20050911"
#application was released 20050910 - next versions will be released as tarballs
#corsair-024.patch from 'mistermix' http://www.oesf.org/forums/index.php?showtopic=14661

inherit palmtop

SRC_URI = "http://ewi546.ewi.utwente.nl/mirror/hrw-oe-sources/corsair_cvs.sourceforge.net__20050911.tar.gz \
           file://corsair-024.patch;patch=1 \
           file://corsair-opie.patch;patch=1"

S = "${WORKDIR}/corsair"

do_configure() {
}

do_install() {
        install -d ${D}${palmtopdir}/pics/
        install -d ${D}${palmtopdir}/apps/Applications/
        install -d ${D}${palmtopdir}/bin
        install -m 0644 ${S}/Corsair.png ${D}${palmtopdir}/pics/
        install -m 0644 ${S}/corsair.desktop ${D}${palmtopdir}/apps/Applications/
        install -m 0644 ${S}/icons/newfeed.png ${S}/icons/get.png ${D}${palmtopdir}/pics/
        install -m 0755 ${S}/corsair ${D}${palmtopdir}/bin/
}
