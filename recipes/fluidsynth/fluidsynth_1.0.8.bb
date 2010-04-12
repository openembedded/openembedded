DESCRIPTION = "Fluidsynth is a software synthesizer"
HOMEPAGE = "http://www.fluidsynth.org/"
SECTION = "libs/multimedia"
LICENSE = "GPLv2"
DEPENDS = "alsa-lib ncurses"

SRC_URI = "http://savannah.nongnu.org/download/fluid/${P}.tar.gz"

inherit autotools pkgconfig lib_package

#Has broken libtool usage
do_configure() {
	gnu-configize
	oe_runconf
}

do_stage() {
	autotools_stage_all
}


SRC_URI[md5sum] = "e2abfd2e69fd8b28d965df968d7d44ee"
SRC_URI[sha256sum] = "45e7c9967d0fb0344f4da539ab343fb979384b36a429a8594c94cf466dff4320"
