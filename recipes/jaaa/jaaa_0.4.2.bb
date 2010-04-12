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

SRC_URI[md5sum] = "e3013bb1e287b495b0668f4b6e2887c7"
SRC_URI[sha256sum] = "0bae72d819963c40e0a202bb08bc55a600fe7c453749601a3836bc9272cffb3a"
