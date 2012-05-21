DESCRIPTION = "An audio Sample Rate Conversion library"
SECTION = "libs"
LICENSE = "GPLv2+"

PR = "r3"

SRC_URI = "http://www.mega-nerd.com/SRC/libsamplerate-${PV}.tar.gz \
           file://libsamplerate-0.1.7-macro-quoting.patch;striplevel=0 \
           file://libsamplerate-0.1.7-tests.patch "
S = "${WORKDIR}/libsamplerate-${PV}"

inherit autotools pkgconfig


SRC_URI[md5sum] = "6731a81cb0c622c483b28c0d7f90867d"
SRC_URI[sha256sum] = "78ed5d9ff1bf162c4a078f6a3e7432a537dd2f22dc58872b081fb01156027fcc"
