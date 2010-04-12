DESCRIPTION = "Ethload for Linux is a tool to send ROM images over ethernet using tftp."
SECTION = "console/network"
LICENSE = "GPL"
SRC_URI = "http://linuxsh.free.fr/tools/cetools-${PV}.tar.gz \
	   file://sean-hsieh.patch;patch=1"
S = "${WORKDIR}/cetools-${PV}"
PR = "r1"

inherit autotools

do_configure() {
	oe_runconf
}

SRC_URI[md5sum] = "58e8706e6d858e48d317cadf550c1224"
SRC_URI[sha256sum] = "dd74c8f27c7b3ff4c7320803674e2446afce93880f84d96dfb142a9fa73db940"
