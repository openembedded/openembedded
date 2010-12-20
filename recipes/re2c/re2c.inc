DESCRIPTION = "Tool for writing very fast and very flexible scanners"
HOMEPAGE = "http://re2c.sourceforge.net/"
AUTHOR = "Marcus Börger helly@users.sourceforge.net"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "PD"

SRC_URI = "${SOURCEFORGE_MIRROR}/${BPN}/${BPN}-${PV}.tar.gz"

BBCLASSEXTEND = "native"

inherit autotools
