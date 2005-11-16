PR = "r2"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org"
LICENSE = "GPL-2"

DEPENDS = "libvorbis libogg libxslt"

SRC_URI = "http://downloads.us.xiph.org/releases/icecast/${PN}-${PV}.tar.gz"

S = "${WORKDIR}/${PN}-${PV}"
inherit autotools

