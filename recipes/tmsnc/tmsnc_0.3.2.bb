DESCRIPTION = "An ncurses based MSN client"
HOMEPAGE = "http://tmsnc.sf.net"
SECTION = "console/network"
LICENSE = "Modified BSD"
DEPENDS = "ncurses openssl"

SRC_URI = "${SOURCEFORGE_MIRROR}/tmsnc/${P}.tar.gz"

EXTRA_OECONF = "--with-openssl --with-openssl=${STAGING_LIBDIR}/.. --with-includedir=${STAGING_INCDIR}"

inherit autotools
