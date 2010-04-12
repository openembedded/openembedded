DESCRIPTION = "Console bittorrent client using libtorrent"
HOMEPAGE = "http://libtorrent.rakshasa.no"
SECTION = "libs/network"
LICENSE = "GPL"
DEPENDS = "libtorrent curl ncurses gnutls libgpg-error"

SRC_URI = "http://libtorrent.rakshasa.no/downloads/rtorrent-${PV}.tar.gz \
           file://autoconf-cross-fix.patch;patch=1"

PR = "r0"

inherit autotools


SRC_URI[md5sum] = "dc0f37d933b0b6c713ad617e09441f3b"
SRC_URI[sha256sum] = "257722380b39e84e700e9f2d2f6600ba724723f1ed59327bfce47a57d293eeee"
