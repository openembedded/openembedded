DESCRIPTION = "Pressure-Sensitive Paint Program for Opie/Qtopia"
SECTION = "opie/applications"
PRIORITY = "optional"
HOMEPAGE = "http://sun.dhis.portside.net/~sakira/wiki/index.cgi?cmd=view;name=LinuxZaurus%3APetitePeinture+en"
LICENSE = "GPL"
APPTYPE = "binary"
APPNAME = "petitpeintu"
APPDESKTOP = "${WORKDIR}"

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

SRC_URI[md5sum] = "8bd0e7e1f4d6549baba4cbb2384de2ff"
SRC_URI[sha256sum] = "4925a4503cf7650e7880740113ee747d1bf828b6783b24580fbcb0ec894c0801"
