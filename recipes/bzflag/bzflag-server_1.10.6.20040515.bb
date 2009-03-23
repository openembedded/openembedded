SECTION = "console/network"
DEPENDS = "adns ncurses"
LICENSE = "LGPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/bzflag/bzflag-${PV}.tar.bz2"
S = "${WORKDIR}/bzflag-${PV}"

inherit autotools

EXTRA_OECONF = "--disable-bzadmin \
		--disable-client"
