DESCRIPTION = "CTorrent is a console BitTorrent client written in the C \
programming language. This version is with the extensions from \
http://www.rahul.net/dholmes/ctorrent/ (dnh2 + vfat patch)"
DEPENDS = "openssl"
LICENSE = "GPL"
SECTION = "network"

SRC_URI = "${SOURCEFORGE_MIRROR}/ctorrent/ctorrent-${PV}.tar.bz2"
S = "${WORKDIR}/ctorrent-${PV}"

inherit autotools
