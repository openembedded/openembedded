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


SRC_URI[md5sum] = "76c818b095248ea9e4b140fff4e2fa2a"
SRC_URI[sha256sum] = "3287c9be61f9ec8ddab99f9b679bbf58610d024bce980307f88151a552ecd1e3"
