#
# nonworking, because the c++ template syntax no longer compiles with modern compilers
#
DESCRIPTION = "An Inputmethod for Opie - frontend to the japanese anthy engine"
HOMEPAGE = "http://zaurus-ja.sourceforge.jp/imkit-anthy.html.en"
SECTION = "opie/inputmethods"
LICENSE = "GPL"
RDEPENDS = "anthy"

SRC_URI = "http://downloads.sourceforge.jp/zaurus-ja/9316/imkit-0.4.5.tar.gz"
S = "${WORKDIR}/imkit-${PV}"

inherit palmtop

PARALLEL_MAKE = ""
QMAKE_PROFILES = "imkit.pro"

do_configure_prepend() {
	echo -e "TEMPLATE=subdirs\nSUBDIRS=libimkit impls/anthy\n" > imkit.pro
}
