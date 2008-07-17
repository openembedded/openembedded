DESCRIPTION = "Fluidsynth is a software synthesizer"
HOMEPAGE = "http://www.fluidsynth.org/"
SECTION = "libs/multimedia"
LICENSE = "GPLv2"
DEPENDS = "alsa-lib ncurses"

SRC_URI = "http://savannah.nongnu.org/download/fluid/${P}.tar.gz"

inherit autotools pkgconfig lib_package

do_stage() {
	autotools_stage_all
}

