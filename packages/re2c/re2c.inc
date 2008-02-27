DESCRIPTION = "Tool for writing very fast and very flexible scanners"
HOMEPAGE = "http://re2c.sourceforge.net/"
AUTHOR = "Marcus Börger helly@users.sourceforge.net"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "PD"

SRC_URI = "${SOURCEFORGE_MIRROR}/re2c/re2c-${PV}.tar.gz"

S = "${WORKDIR}/re2c-${PV}"

inherit autotools
