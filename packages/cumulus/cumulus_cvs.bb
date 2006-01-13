DESCRIPTION = "A flightcomputer application for Qt/E based Palmtop Environments"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
APPTYPE = "binary"
APPNAME = "cumulus"
APPDESKTOP = "${S}"
PV = "${OPIE_CVS_PV}"
PR = "r0"

SRC_URI = "http://www.kflog.org/fileadmin/user_upload/cumulus_snapshots/cumulus-snapshot.tbz"
S = "${WORKDIR}/cumulus/cumulus"

inherit opie

DEFAULT_PREFERENCE = "-1"

export OE_QMAKE_LINK="${CXX}"
EXTRA_QMAKEVARS_POST = "INCLUDEPATH+=-I."

#
# nasty hack since cumulus doesn't obey the qmake standard which requires just one .pro file per directory
#
do_compile() {
	echo "#define SHARP_PDA_WARNSOUND 4" >sharp_char.h
	qmake -makefile -spec ${QMAKESPEC} -after ${EXTRA_QMAKEVARS_POST} cumulus.pro
	oe_runmake
	qmake -makefile -spec ${QMAKESPEC} -after ${EXTRA_QMAKEVARS_POST} gpsClient.pro 
	oe_runmake
}

do_install() {
        install -d ${D}${palmtopdir}/pics/cumulus \
                   ${D}${palmtopdir}/pics/cumulus/small \
                   ${D}${palmtopdir}/pics/cumulus/windarrows
        install -m 0644 ../cumulus.png ${D}${palmtopdir}/pics/cumulus/cumulus.png
        install -m 0644 map-icons/*.png ${D}${palmtopdir}/pics/cumulus
        install -m 0644 map-icons/*.xpm ${D}${palmtopdir}/pics/cumulus
        install -m 0644 map-icons/small/*.png ${D}${palmtopdir}/pics/cumulus/small
        install -m 0644 map-icons/small/*.xpm ${D}${palmtopdir}/pics/cumulus/small
        install -m 0644 map-icons/windarrows/*.png ${D}${palmtopdir}/pics/cumulus/windarrows

	install -m 0755 gpsClient ${D}${palmtopdir}/bin/
}
