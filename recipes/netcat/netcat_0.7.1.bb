DESCRIPTION = "GNU Netcat"
HOMEPAGE = "http://netcat.sourceforge.net"
SECTION = "console/network"
LICENSE = "GPLv2"
PR = "r4"

SRC_URI = "${SOURCEFORGE_MIRROR}/netcat/netcat-${PV}.tar.bz2"

inherit autotools update-alternatives gettext

do_install_append() {
	mv ${D}${bindir}/nc ${D}${bindir}/nc.${PN}
}

ALTERNATIVE_NAME = "nc"
ALTERNATIVE_LINK = "${bindir}/nc"
ALTERNATIVE_PATH = "${bindir}/nc.${PN}"
ALTERNATIVE_PRIORITY = "100"
