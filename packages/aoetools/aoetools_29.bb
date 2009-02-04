DESCRIPTION = "ATA over Ethernet Tools"
SECTION = "console/network"
RRECOMMENDS = "kernel-module-aoe"
PR = "r0"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz"

inherit autotools
