DESCRIPTION = "Network usage monitor"
HOMEPAGE = "http://www.ex-parrot.com/pdw/iftop/"
SECTION = "console/network"
LICENSE = "GPLv2+"
DEPENDS = "libpcap ncurses"

SRC_URI = "http://www.ex-parrot.com/pdw/iftop/download/iftop-${PV}.tar.gz"
SRC_URI[md5sum] = "062bc8fb3856580319857326e0b8752d"
SRC_URI[sha256sum] = "d032547c708307159ff5fd0df23ebd3cfa7799c31536fa0aea1820318a8e0eac"

inherit autotools
