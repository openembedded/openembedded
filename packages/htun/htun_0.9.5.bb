DESCRIPTION = "Http tunnelling daemon"
SECTION = "network"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
HOMEPAGE = "http://htun.runslinux.net"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://htun.runslinux.net/dist/htun-${PV}.tar.gz"
S = "${WORKDIR}/htun-${PV}/src"

PARALLEL_MAKE = ""

inherit autotools

do_install() {
	install -d ${D}${sbindir}
	install -m 0755 htund ${D}${sbindir}
}
