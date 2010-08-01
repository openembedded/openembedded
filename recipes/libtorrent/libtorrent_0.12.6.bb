DESCRIPTION = "library implementing the bittorrent protocol"
HOMEPAGE = "http://libtorrent.rakshasa.no"
SECTION = "libs/network"
LICENSE = "GPL"
DEPENDS = "libsigc++-2.0 openssl"

SRC_URI = "http://libtorrent.rakshasa.no/downloads/libtorrent-${PV}.tar.gz"
PR = "r0"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-aligned"

SRC_URI[md5sum] = "037499ed708aaf72988cee60e5a8d96b"
SRC_URI[sha256sum] = "7b02f33164966a05261e83bad76eef537198fefe76eaf57dfd64bb27c7d77129"

