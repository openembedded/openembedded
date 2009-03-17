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
