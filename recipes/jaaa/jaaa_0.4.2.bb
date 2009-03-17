DESCRIPTION = "JACK and ALSA Audio Analyzer from http://www.kokkinizita.net/linuxaudio/"
SECTION = "x11/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r0"

DEPENDS = "clthreads clxclient clalsadrv jack freetype fftwf"

SRC_URI = "http://www.kokkinizita.net/linuxaudio/downloads/jaaa-${PV}.tar.bz2 \
			file://jaaa-Makefile.patch;patch=1 \
"

S = "${WORKDIR}/jaaa"

inherit autotools pkgconfig

do_stage() {
       autotools_stage_all
}
