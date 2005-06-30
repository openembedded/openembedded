DESCRIPTION = "Qtopia/Opie Input helper for USB devices"
SECTION = "opie/inputmethods"
HOMEPAGE = "http://tbox.jpn.org/wiki/linuzau/wiki.cgi"
LICENSE = "GPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PR = "r0"
APPNAME = "qpeinputhelper"

SRC_URI = "http://tbox.jpn.org/data/inputhelper_${PV}_src.tar.gz"
S = "${WORKDIR}/src"

inherit opie

do_configure_prepend() {
	rm -f makefile
	qmake -project -t lib -o qpeinputhelper.pro
}

