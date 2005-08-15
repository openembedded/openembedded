DEPENDS = "libxslt"
PR = "r1"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org"
LICENCE = "GPL-2"

DEPENDS = "libvorbis libogg"

SRC_URI = "http://downloads.us.xiph.org/releases/icecast/${PN}-${PV}.tar.gz"

S = "${WORKDIR}/${PN}-${PV}"
inherit autotools

