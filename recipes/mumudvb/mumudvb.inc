DESCRIPTION = "redistributes streams from DVB on a network using multicast or HTTP unicast"
AUTHOR = "Brice Dubost"
HOMEPAGE = "http://mumudvb.braice.net/"
SECTION = "console/multimedia"
PRIORITY = "optional"
LICENSE = "GPLv2"

SRC_URI = "http://mumudvb.braice.net/mumudvb/${P}/mumudvb_${PV}.tar.gz"

S = "${WORKDIR}/mumudvb"

inherit autotools
