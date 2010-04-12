DESCRIPTION = "Http tunnelling daemon"
SECTION = "network"
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

SRC_URI[md5sum] = "f720686c841e9fefc06db76458fd9908"
SRC_URI[sha256sum] = "1f8259a3a8ae583170816f5028329f3a7157f87f927da9c0a911a5fb9be263a1"
