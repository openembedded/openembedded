DESCRIPTION = "CTorrent is a console BitTorrent client written in the C \
programming language."
DEPENDS = "openssl"
LICENSE = "GPL"
SECTION = "network"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/ctorrent/ctorrent-${PV}.tar.gz"
S = "${WORKDIR}/ctorrent-${PV}"

inherit autotools
