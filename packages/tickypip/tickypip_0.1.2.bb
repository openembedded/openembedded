DESCRIPTION = "Tickypip"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
LICENSE = "GPL"
AUTHOR = "Christian Hammond"
HOMEPAGE = "http://www.chipx86.com/projects/tickypip/"
RRECOMMENDS = "tickypip-levels"
PR = "r4"

SRC_URI = "http://www.chipx86.com/packages/ipkg/tickypip-0.1.2.tar.gz \
           file://tickypip.desktop \
           file://tickypip.png"

APPNAME = "tickypip"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}"

QMAKE_PROFILES = "tickypip.pro"
EXTRA_QMAKEVARS_POST += "DEFINES-=LOCAL_COMPILE"

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${WORKDIR}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/images/*.png ${D}${palmtopdir}/pics/${APPNAME}/

# copy share
	install -d ${D}${palmtopdir}/share/${APPNAME}/levels
	install -m 0644 ${S}/levels/* ${D}${palmtopdir}/share/${APPNAME}/levels/
}


inherit opie
