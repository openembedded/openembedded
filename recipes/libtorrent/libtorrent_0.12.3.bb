DESCRIPTION = "library implementing the bittorrent protocol"
HOMEPAGE = "http://libtorrent.rakshasa.no"
SECTION = "libs/network"
LICENSE = "GPL"
DEPENDS = "libsigc++-2.0 openssl"

SRC_URI = "http://libtorrent.rakshasa.no/downloads/libtorrent-${PV}.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-aligned"

do_stage() {
	autotools_stage_all
}

