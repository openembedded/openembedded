DESCRIPTION = "htop process monitor"
HOMEPAGE = "http://htop.sf.net"
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPLv2"

DEPENDS = "ncurses"

SRC_URI = "${SOURCEFORGE_MIRROR}/htop/htop-${PV}.tar.gz \
           file://remove-proc-test.patch;patch=1"

inherit autotools

SRC_URI[md5sum] = "4afc961fa709167e1b434682897991f9"
SRC_URI[sha256sum] = "1361f4f0b92d7e6bdac25a4b7ee138a7ee83b5a9368820f5aa518051ca82862b"
