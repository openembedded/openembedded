DESCRIPTION = "An audio Sample Rate Conversion library"
SECTION = "libs"
LICENSE = "GPL libsamplerate"

PR = "r1"

SRC_URI = "http://www.mega-nerd.com/SRC/libsamplerate-${PV}.tar.gz \
           file://libsamplerate-0.1.7-macro-quoting.patch;patch=1;pnum=0 \
           file://libsamplerate-0.1.7-tests.patch;patch=1 "
S = "${WORKDIR}/libsamplerate-${PV}"

inherit autotools pkgconfig


SRC_URI[md5sum] = "ad093e60ec44f0a60de8e29983ddbc0f"
SRC_URI[sha256sum] = "e0a646224a0323ac63f56ef009b2d7fee11452a7b8af139b19ae71d2890dbc9c"
