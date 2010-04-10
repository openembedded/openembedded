DESCRIPTION = "An ncurses based MSN client"
HOMEPAGE = "http://tmsnc.sf.net"
SECTION = "console/network"
LICENSE = "Modified BSD"
DEPENDS = "ncurses openssl"

SRC_URI = "${SOURCEFORGE_MIRROR}/tmsnc/${P}.tar.gz"

EXTRA_OECONF = "--with-openssl --with-openssl=${STAGING_LIBDIR}/.. --with-includedir=${STAGING_INCDIR}"

inherit autotools

SRC_URI[md5sum] = "337dae91d4775e03b6681f61db56d2a7"
SRC_URI[sha256sum] = "7f54ba3974f45c0787b6d62d0d62ce352ddbf95419123b98b4969b97d3dfed23"
