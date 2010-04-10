DESCRIPTION = "Console bittorrent client using libtorrent"
HOMEPAGE = "http://libtorrent.rakshasa.no"
SECTION = "libs/network"
LICENSE = "GPL"
DEPENDS = "libtorrent curl ncurses gnutls libgpg-error"

SRC_URI = "http://libtorrent.rakshasa.no/downloads/rtorrent-${PV}.tar.gz \
           file://autoconf-cross-fix.patch;patch=1"

inherit autotools


SRC_URI[md5sum] = "d1b43acf08e371a56915293bbcf584c6"
SRC_URI[sha256sum] = "554456550ca6e792297d6d39367120af5b2bd6181d514a43faf4e2f565721908"
