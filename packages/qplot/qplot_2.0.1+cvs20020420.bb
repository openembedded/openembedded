DESCRIPTION = "QPlot is an Advanced Matematical Calculator for Qt/Embedded based Palmtop Environments"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
HOMEPAGE = "http://qplot.sourceforge.net/"
CVSDATE = 20020420
PV = "2.0.1-cvs-${CVSDATE}"
PR = "r1"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/qplot;module=qplot \
	   file://gcc3.patch;patch=1"
S = "${WORKDIR}/qplot"

inherit palmtop

do_install() {
	install -d ${D}${palmtopdir}/bin \
		   ${D}${palmtopdir}/apps/Applications \
		   ${D}${palmtopdir}/pics \
		   ${D}${palmtopdir}/lib \
		   ${D}${palmtopdir}/plugins/inputmethods
        install -m 755 qplotmain/qplot ${D}${palmtopdir}/bin/qplot
        install -m 644 qplotmain/qplot.png ${D}${palmtopdir}/pics/
        install -m 644 qplotmain/qplot-const.b ${D}${palmtopdir}/lib/
        install -m 644 qplotmain/qplot-math.b ${D}${palmtopdir}/lib/
	oe_libinstall -so -C qplotmath libqplotmath ${D}${palmtopdir}/plugins/inputmethods/
        install -m 644 qplot.desktop ${D}${palmtopdir}/apps/Applications/qplot.desktop
}
