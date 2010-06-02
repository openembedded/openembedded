DESCRIPTION = "A GPS navigation application for the Opie environment"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://qpegps.sourceforge.net/"

DEPENDS = "gpsd"
RRECOMMENDS_${PN} = "gpsd"

SRC_URI = "${SOURCEFORGE_MIRROR}/qpegps/qpegps_${PV}_src.zip \
           file://qpegps.desktop \
           file://qpegps.png"
S = "${WORKDIR}/qpegps"

inherit palmtop

QMAKE_PROFILES = "qpegps.pro"
EXTRA_QMAKEVARS_POST = "LIBS=-lqpe LIBS+=-lgps"
OE_QMAKE_CFLAGS += " -DQWS "
OE_QMAKE_LIBS_QT = ${QT_LIBRARY}

do_install() {
        install -d ${D}${palmtopdir}/bin \
        	   ${D}${palmtopdir}/apps/Applications \
        	   ${D}${palmtopdir}/pics \
        	   ${D}${palmtopdir}/help/html/qpegps_icons \
        	   ${D}${palmtopdir}/qpegps/maps \
        	   ${D}${palmtopdir}/qpegps/icons \
        	   ${D}${palmtopdir}/qpegps/tracks
        install -m 0755 qpegps ${D}${palmtopdir}/bin/
        install -m 0644 ${WORKDIR}/qpegps.desktop ${D}${palmtopdir}/apps/Applications/
        install -m 0644 ${WORKDIR}/qpegps.png ${D}${palmtopdir}/pics/
        install -m 0644 doc/qpegps.html ${D}${palmtopdir}/help/html/
        install -m 0644 doc/qpegps_icons/*.png ${D}${palmtopdir}/help/html/qpegps_icons/
        install -m 0644 icons/*.xpm ${D}${palmtopdir}/qpegps/icons/
	install -m 0644 datum/*.dat ${D}${palmtopdir}/qpegps/
}
