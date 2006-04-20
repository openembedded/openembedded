DESCRIPTION = "Polypaudio is a sound server for Linux and other Unix like operating systems"
HOMEPAGE = "http://0pointer.de/lennart/projects/polypaudio"
AUTHOR = "Lennart Poettering"
SECTION = "libs"
LICENSE = "LGPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "liboil libsamplerate0 libsndfile1 libtool"

SRC_URI = "http://0pointer.de/lennart/projects/polypaudio/polypaudio-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--disable-lynx --without-x --without-glib --without-alsa --with-oss"

PARALLEL_MAKE = ""
