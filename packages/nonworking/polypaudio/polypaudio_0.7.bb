DESCRIPTION = "Polypaudio is a sound server for Linux and other Unix like operating systems"
SECTION = "libs"
LICENSE = "LGPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "libtool libsamplerate0 libsndfile1"

SRC_URI = "http://0pointer.de/lennart/projects/polypaudio/polypaudio-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--disable-lynx --without-x --without-glib --without-alsa --with-oss"

