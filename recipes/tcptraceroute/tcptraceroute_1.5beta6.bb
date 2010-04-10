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

SRC_URI[md5sum] = "0200707ad81b88c31439820ae9bc5102"
SRC_URI[sha256sum] = "08ce9b24ab7b6ad45ac7f668eccfb7007ef182406f7db0b7e455decfb0b49bec"
