DESCRIPTION = "htop process monitor"
HOMEPAGE = "http://htop.sf.net"
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPLv2"

DEPENDS = "ncurses"

SRC_URI = "${SOURCEFORGE_MIRROR}/htop/htop-${PV}.tar.gz \
           file://remove-proc-test.patch;patch=1"

inherit autotools
