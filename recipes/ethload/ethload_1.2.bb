SECTION = "console/network"
DESCRIPTION = "Ethload for Linux is a tool to send ROM images over ethernet using tftp."
LICENSE = "GPL"
SRC_URI = "http://ludovic.lange.free.fr/CETools/ethload-${PV}.tar.gz"
S = "${WORKDIR}/ethload-${PV}"

inherit autotools

do_configure() {
	oe_runconf
}

SRC_URI[md5sum] = "0e8cac9311ece27bed363d842c63dc50"
SRC_URI[sha256sum] = "8a27bae79247f893592b9e919f80c6f01c082d8ac7320602490106c758a9c762"
