DESCRIPTION = "Navigation application for use with GPS adapters"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
RRECOMMENDS = "gpsd"
LICENSE = "GPL"
HOMEPAGE = "http://qpegps.sourceforge.net/"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/qpegps/qpegps_${PV}_source.zip \
           file://qpegps.desktop \
           file://qpegps.png"
S = "${WORKDIR}/root/qpegps_src_my/qpegps_my"

inherit palmtop

QMAKE_PROFILES = "qpegps.pro"
EXTRA_QMAKEVARS_POST = "LIBS=-lqpe"

do_install() {
        install -d ${D}${palmtopdir}/bin \
        	   ${D}${palmtopdir}/apps/Applications \
        	   ${D}${palmtopdir}/pics/qpegps \
        	   ${D}${palmtopdir}/help/html/qpegps_icons \
        	   ${D}${palmtopdir}/qpegps/maps \
        	   ${D}${palmtopdir}/qpegps/icons \
        	   ${D}${palmtopdir}/qpegps/tracks
        install -m 0755 qpegps ${D}${palmtopdir}/bin/
        install -m 0644 ${WORKDIR}/qpegps.desktop ${D}${palmtopdir}/apps/Applications/
        install -m 0644 ${WORKDIR}/qpegps.png ${D}${palmtopdir}/pics/qpegps/
        install -m 0644 doc/qpegps.html ${D}${palmtopdir}/help/html/
        install -m 0644 doc/qpegps_icons/*.png ${D}${palmtopdir}/help/html/qpegps_icons/
        install -m 0644 icons/*.xpm ${D}${palmtopdir}/qpegps/icons/
	install -m 0644 datum/*.dat ${D}${palmtopdir}/qpegps/
}
