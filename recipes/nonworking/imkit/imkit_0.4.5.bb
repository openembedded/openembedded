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

SRC_URI[md5sum] = "de20bff9734595553f9a2b79cf3db719"
SRC_URI[sha256sum] = "3832a7f8ca6ef03c2ea32e364be854a4eb2396053516c5f048fca910d8d8fc08"

inherit palmtop

PARALLEL_MAKE = ""
QMAKE_PROFILES = "imkit.pro"

do_configure_prepend() {
	printf "TEMPLATE=subdirs\nSUBDIRS=libimkit impls/anthy\n" > imkit.pro
}
