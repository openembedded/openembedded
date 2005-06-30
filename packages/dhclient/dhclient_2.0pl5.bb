SECTION = "console/network"
DESCRIPTION = "ISC DHCP Distribution (client and server)."
LICENSE = "BSD"

SRC_URI = "ftp://ftp.isc.org/isc/dhcp/dhcp-${PV}.tar.gz \
	   file://make.patch;patch=1"
S = "${WORKDIR}/dhcp-${PV}"

export BINDIR = "${sbindir}"

do_configure () {
	./configure ${TARGET_SYS}
}

do_install () {
	oe_runmake "DESTDIR=${D}" install
}
