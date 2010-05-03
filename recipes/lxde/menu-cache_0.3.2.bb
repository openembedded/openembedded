DESCRIPTION = "LXDE menucache"
SECTION = "x11"
LICENSE = "GPLv2"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "ac4a9ea77db68d3db3f9f53cc75af66a"
SRC_URI[sha256sum] = "6b7c1627b5102d8301a8a3e845f673a7181a71dde32f6455abf22d03e392b89f"

inherit autotools
