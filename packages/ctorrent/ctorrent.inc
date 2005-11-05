DESCRIPTION = "CTorrent is a console BitTorrent client written in the C \
programming language."
DEPENDS = "openssl"
LICENSE = "GPL"
SECTION = "network"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"

SRC_URI = "${SOURCEFORGE_MIRROR}/ctorrent/ctorrent-${PV}.tar.bz2"
S = "${WORKDIR}/ctorrent-${PV}"

inherit autotools
