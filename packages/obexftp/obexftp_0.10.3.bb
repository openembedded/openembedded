LICENSE = GPL
DESCRIPTION = "OBEX Ftp Client"
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = "openobex"

SRC_URI = "${SOURCEFORGE_MIRROR}/openobex/obexftp-${PV}.tar.gz \
	   file://m4.patch;patch=1"

inherit autotools 

#EXTRA_OEMAKE = "'SUBDIRS=bfb cobexbfb cobexpe obexftp apps vmo doc'"
EXTRA_OEMAKE = "'SUBDIRS=bfb cobexbfb cobexpe obexftp apps vmo'"
