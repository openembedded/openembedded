SECTION = "console/network"
DESCRIPTION = "IPv6 router advertisement daemon"
LICENSE = "BSD"
SRC_URI = "http://v6web.litech.org/radvd/dist/radvd-${PV}.tar.gz \
	   file://automake.patch;patch=1"
S = "${WORKDIR}/radvd-${PV}"

inherit autotools
