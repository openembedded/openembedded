DESCRIPTION = "Pressure-Sensitive Paint Program for Opie/Qtopia"
SECTION = "opie/applications"
PRIORITY = "optional"
HOMEPAGE = "http://sun.dhis.portside.net/~sakira/wiki/index.cgi?cmd=view;name=LinuxZaurus%3APetitePeinture+en"
LICENSE = "GPL"
APPTYPE = "binary"
APPNAME = "petitpeintu"
APPDESKTOP = "${WORKDIR}"
MAINTAINER = "Frederic Devernay <frederic.devernay@m4x.org>"

SRC_URI = "http://sun.dhis.portside.net/~sakira/archive/SPainter_1.5_src.tar.gz \
           file://dialogs.patch;patch=1 \
           file://petitpeintu.desktop \
           file://petitpeintu.png "
S = "${WORKDIR}/SPainter"

inherit opie

QMAKE_PROFILES = "spainter.pro"

do_install() {
        install -d ${D}${palmtopdir}/pics
        install -m 0644 *.png ${D}${palmtopdir}/pics/
        install -m 0644 ${WORKDIR}/petitpeintu.png ${D}${palmtopdir}/pics/
}
