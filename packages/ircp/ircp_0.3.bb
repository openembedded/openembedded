DEPENDS = "openobex"
LICENSE = "GPL"
FILE_PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/openobex/ircp-${PV}.tar.gz"

EXTRA_OECONF = "--with-openobex=${STAGING_LIBDIR} "

inherit autotools
