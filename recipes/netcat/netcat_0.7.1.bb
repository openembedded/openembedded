DESCRIPTION = "GNU Netcat"
HOMEPAGE = "http://netcat.sourceforge.net"
SECTION = "console/network"
LICENSE = "GPLv2"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/netcat/netcat-${PV}.tar.bz2"

inherit autotools update-alternatives

do_install_append() {
	mv ${D}${bindir}/nc ${D}${bindir}/nc.${PN}
}

ALTERNATIVE_NAME = "nc"
ALTERNATIVE_LINK = "${bindir}/nc"
ALTERNATIVE_PATH = "${bindir}/nc.${PN}"
ALTERNATIVE_PRIORITY = "100"

SRC_URI[md5sum] = "0a29eff1736ddb5effd0b1ec1f6fe0ef"
SRC_URI[sha256sum] = "b55af0bbdf5acc02d1eb6ab18da2acd77a400bafd074489003f3df09676332bb"
