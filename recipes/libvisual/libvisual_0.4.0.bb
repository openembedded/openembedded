DESCRIPTION = "A cross platform audio visualization library"
HOMEPAGE = "http://libvisual.sf.net"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL GPL"
SRC_URI = "${SOURCEFORGE_MIRROR}/libvisual/libvisual-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage() {
  autotools_stage_all
}

SRC_URI[md5sum] = "f4e78547c79ea8a8ad111cf8b85011bb"
SRC_URI[sha256sum] = "0b4dfdb87125e129567752089e3c8b54cefed601eef169d2533d8659da8dc1d7"
