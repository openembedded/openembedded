SECTION = "console/network"
DESCRIPTION = "Ethload for Linux is a tool to send ROM images over ethernet using tftp."
LICENSE = "GPL"
SRC_URI = "http://ludovic.lange.free.fr/CETools/ethload-${PV}.tar.gz"
S = "${WORKDIR}/ethload-${PV}"

inherit autotools

do_configure() {
	oe_runconf
}
