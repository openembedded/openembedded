DESCRIPTION = "Console bittorrent client using libtorrent"
HOMEPAGE = "http://libtorrent.rakshasa.no"
SECTION = "libs/network"
LICENSE = "GPL"
DEPENDS = "libtorrent curl ncurses gnutls libgpg-error"

SRC_URI = "http://libtorrent.rakshasa.no/downloads/rtorrent-${PV}.tar.gz \
           file://autoconf-cross-fix.patch;patch=1"

inherit autotools


SRC_URI[md5sum] = "6216be7ce5e3ead9dc115eaeea863694"
SRC_URI[sha256sum] = "597cefac4535d7f3b752253e5997b3c851c261b26b966a39beb032dcf1d5baa7"
