SECTION = "console/network"
DESCRIPTION = "A traceroute implementation that uses TCP packets. This \
allows it to bypass a lot of firewalls that block the traditional ping \
and traceroute packets."
HOMEPAGE = "http://michael.toren.net/code/tcptraceroute/"
LICENSE = "GPL"
PRIORITY = "optional"
DEPENDS = "libnet-1.1"
PR = "r0"

SRC_URI = "http://michael.toren.net/code/tcptraceroute/tcptraceroute-${PV}.tar.gz \
	   file://configure.ac.patch;patch=1"

inherit autotools
