DESCRIPTION = "library implementing the bittorrent protocol"
HOMEPAGE = "http://libtorrent.rakshasa.no"
SECTION = "libs/network"
LICENSE = "GPL"
DEPENDS = "libsigc++-2.0 openssl"

SRC_URI = "http://libtorrent.rakshasa.no/downloads/libtorrent-${PV}.tar.gz"
PR = "r0"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-aligned"

do_stage() {
	autotools_stage_all
}


SRC_URI[md5sum] = "7e4b4c29a69c86c38e3e60ec11fc2255"
SRC_URI[sha256sum] = "a48c307fdcc77a28ee3a2ba0b68501a42e3709bf693c52df4831b87c71c8c359"
