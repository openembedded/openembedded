DEPENDS = "openobex"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/openobex/ircp-${PV}.tar.gz"

EXTRA_OECONF="--prefix=${D}"


inherit autotools

