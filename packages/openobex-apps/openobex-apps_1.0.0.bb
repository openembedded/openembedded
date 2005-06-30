LICENSE = GPL
DESCRIPTION = "Applications for OpenOBEX"
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = "openobex"

SRC_URI = "${SOURCEFORGE_MIRROR}/openobex/openobex-apps-${PV}.tar.gz \
	   file://m4.patch;patch=1 \
	   file://gcc34.patch;patch=1"

inherit autotools 

EXTRA_OECONF = "--disable-glibtest --with-glib-prefix=${STAGING_LIBDIR}/.."
EXTRA_OEMAKE = "'INCLUDES='"
