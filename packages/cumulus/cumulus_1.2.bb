DESCRIPTION = "A flightcomputer application for Qt/E based Palmtop Environments"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
APPTYPE = "binary"
APPNAME = "cumulus"
APPDESKTOP = "${S}"
PR = "r0"

SRC_URI = "http://cumulus.kflog.org/download/src/cumulus-${PV}.src.tar.bz2 \
           file://qtooltip.patch;patch=1"
S = "${WORKDIR}/cumulus-arm-${PV}/cumulus"

inherit opie

export OE_QMAKE_LINK="${CXX}"
EXTRA_QMAKEVARS_POST = "INCLUDEPATH+=-I."

#
# nasty hack since cumulus doesn't obey the qmake standard which requires just one .pro file per directory
#
do_compile() {
	qmake -makefile -spec ${QMAKESPEC} -after ${EXTRA_QMAKEVARS_POST} cumulus.pro
	oe_runmake
	qmake -makefile -spec ${QMAKESPEC} -after ${EXTRA_QMAKEVARS_POST} gpsClient.pro 
	oe_runmake
}

do_install() {
        install -d ${D}${palmtopdir}/pics/mapicons
        install -m 0644 ../cumulus.png ${D}${palmtopdir}/pics/cumulus.png
        cp -a map-icons/* ${D}${palmtopdir}/pics/mapicons

	install -m 0755 gpsClient ${D}${palmtopdir}/bin/
}
