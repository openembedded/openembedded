DESCRIPTION = "A cross platform audio visualization library"
HOMEPAGE = "http://libvisual.sf.net"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPLv2.1+ GPLv2"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/libvisual/libvisual-${PV}.tar.gz \
           file://no-libdir.patch \
          "

inherit autotools pkgconfig

SRC_URI[md5sum] = "f4e78547c79ea8a8ad111cf8b85011bb"
SRC_URI[sha256sum] = "0b4dfdb87125e129567752089e3c8b54cefed601eef169d2533d8659da8dc1d7"
