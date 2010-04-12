DESCRIPTION = "Nabi is an easy and powerful GNU XIM for the Korean language"
HOMEPAGE = "http://nabi.kldp.net/"
SECTION = "x11/input"
LICENSE = "GPL"
DEPENDS = "gtk+ libhangul"

SRC_URI = "http://kldp.net/frs/download.php/3742/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig

SRC_URI[md5sum] = "8746890ea666ac1b7ae6db77993c6592"
SRC_URI[sha256sum] = "1a239a7bb0644441ca781459fbf5a1c5fb95e823351bf308aa680eb60cc45b94"
