DESCRIPTION = "Interactive console program which monitors and displays squid logs"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "ncurses"
RDEPENDS = "squid"

S = "${WORKDIR}/squidview-${PV}"

SRC_URI = "http://www.rillion.net/squidview/squidview-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "4809dcf89e504d4039ed01c9f61c68d5"
SRC_URI[sha256sum] = "3da4fccc40c7c8ad51dba5bc7ac29a3a53905d5f2de0761353214d7e359d4bfd"
