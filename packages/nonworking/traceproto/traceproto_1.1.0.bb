DESCRIPTION = "Traceproto is a traceroute replacement that allows the user \
to specify the protocol and port to trace to. It currently supports TCP, UDP, and ICMP traces."
DEPENDS = "libpcap"
SECTION = "console/network"
MAINTAINER = "Michael 'Mickey' Lauer"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/traceproto/traceproto-${PV}.tar.gz"

inherit autotools

do_configure() {
	oe_runconf
}

