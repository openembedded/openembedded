DESCRIPTION = "An audio Sample Rate Conversion library"
SECTION = "libs"
LICENSE = "GPL libsamplerate"

PR = "r1"

SRC_URI = "http://www.mega-nerd.com/SRC/libsamplerate-${PV}.tar.gz \
           file://libsamplerate-0.1.7-macro-quoting.patch;patch=1;pnum=0 \
           file://libsamplerate-0.1.7-tests.patch;patch=1 "
S = "${WORKDIR}/libsamplerate-${PV}"

inherit autotools pkgconfig

