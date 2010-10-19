DESCRIPTION = "Console bittorrent client using libtorrent"
HOMEPAGE = "http://libtorrent.rakshasa.no"
SECTION = "libs/network"
LICENSE = "GPL"
DEPENDS = "libtorrent curl ncurses gnutls libgpg-error xmlrpc-c"

SRC_URI = "http://libtorrent.rakshasa.no/downloads/rtorrent-${PV}.tar.gz \
           file://autoconf-cross-fix.patch \
           file://checks.patch"

EXTRA_OECONF = " --with-xmlrpc-c"

PR = "r2"

inherit autotools

SRC_URI[md5sum] = "b804c45c01c40312926bcea6b55bb084"
SRC_URI[sha256sum] = "8c96c68e1524162abd1fc4b612d0c3d924fccc25159c0b3f208e69281f0b32db"
