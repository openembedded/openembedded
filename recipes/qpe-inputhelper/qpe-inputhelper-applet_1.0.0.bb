DESCRIPTION = "Qtopia/Opie Input helper for USB devices"
SECTION = "opie/inputmethods"
HOMEPAGE = "http://tbox.jpn.org/wiki/linuzau/wiki.cgi"
LICENSE = "GPL"
PR = "r0"
APPNAME = "qpeinputhelper"

SRC_URI = "http://tbox.jpn.org/data/inputhelper_${PV}_src.tar.gz"
S = "${WORKDIR}/src"

inherit opie

do_configure_prepend() {
	rm -f makefile
	qmake -project -t lib -o qpeinputhelper.pro
}


SRC_URI[md5sum] = "d99128113077a9b0c8f4aebeaec38d27"
SRC_URI[sha256sum] = "4bf2d82a434863737cb505d03c7edf4e09ae3dfb3aa2c250079b68a60aaa629f"
