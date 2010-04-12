DESCRIPTION = "Traceproto is a traceroute replacement that allows the user \
to specify the protocol and port to trace to. It currently supports TCP, UDP, and ICMP traces."
DEPENDS = "libpcap"
SECTION = "console/network"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/traceproto/traceproto-${PV}.tar.gz"

inherit autotools

do_configure() {
	oe_runconf
}


SRC_URI[md5sum] = "265d558d8689790cdb158b7d46c88b31"
SRC_URI[sha256sum] = "339157f45a1c5a02531adbcecc46334c5a81ffe6643d308940723ad66435607b"
