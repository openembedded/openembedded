SECTION = "console/network"
DESCRIPTION = "ISC DHCP Distribution (client and server)."
LICENSE = "BSD"
PR = "r1"

SRC_URI = "ftp://ftp.isc.org/isc/dhcp/dhcp-2.0-history/dhcp-${PV}.tar.gz \
	   file://make.patch;patch=1"
S = "${WORKDIR}/dhcp-${PV}"

export BINDIR = "${sbindir}"
export LFLAGS = "${LDFLAGS}"

do_configure () {
	./configure ${TARGET_SYS}
}

do_install () {
	oe_runmake "DESTDIR=${D}" install
}

SRC_URI[md5sum] = "ab22f363a7aff924e2cc9d1019a21498"
SRC_URI[sha256sum] = "ef0fa044354ea42983584fcf94838445d8c8167b07630ad1a1057ea4783794b7"
