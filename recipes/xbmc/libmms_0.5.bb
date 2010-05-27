DESCRIPTION = "LibMMS is a common library for parsing mms:// and mmsh:// type network streams."
LICENSE = "LGPLv2.1"

DEPENDS = "glib-2.0"

SRC_URI = "http://launchpad.net/libmms/trunk/${PV}/+download/libmms-${PV}.tar.gz"
SRC_URI[md5sum] = "cf83053ec891f14e73a04c84d9de08ee"
SRC_URI[sha256sum] = "02d9ca2b16b1517b84edb6c1c378a1f447679a831ba708a0396b30852aa6f091"

inherit autotools

