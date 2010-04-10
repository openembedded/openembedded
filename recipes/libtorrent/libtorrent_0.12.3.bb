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


SRC_URI[md5sum] = "db7c7a2236c2f6af5e02cf3e9384eb67"
SRC_URI[sha256sum] = "6044618e37c2925615a08517e8b69ef84147ef5287a222fc451968b36a0a9be7"
