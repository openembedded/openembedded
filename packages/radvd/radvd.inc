DESCRIPTION = "IPv6 router advertisement daemon"
HOMEPAGE = "http://www.litech.org/radvd/"
SECTION = "console/network"
LICENSE = "BSD"
DEPENDS = "flex-native"

SRC_URI = "http://v6web.litech.org/radvd/dist/radvd-${PV}.tar.gz;md5sum=${MD5SUM}"

S = "${WORKDIR}/radvd-${PV}"

inherit autotools
